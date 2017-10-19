/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.rennan.vfrplanning.model.Aerodromo;
import br.rennan.vfrplanning.model.Aeronave;
import br.rennan.vfrplanning.model.CalculoPeso;
import br.rennan.vfrplanning.model.MedidaCombustivel;
import br.rennan.vfrplanning.model.PeriodoVoo;
import br.rennan.vfrplanning.model.PlanoDeVoo;
import br.rennan.vfrplanning.model.RegraParImpar;
import br.rennan.vfrplanning.model.RegraVoo;
import br.rennan.vfrplanning.model.TipoRegraVoo;
import br.rennan.vfrplanning.model.Trecho;
import br.rennan.vfrplanning.repository.Aerodromos;
import br.rennan.vfrplanning.repository.Aeronaves;
import br.rennan.vfrplanning.service.CadastroPlanoDeVooService;
import br.rennan.vfrplanning.service.NegocioException;
import br.rennan.vfrplanning.util.jsf.FacesUtil;

/**
 *
 * @author rennan.lima
 */
@Named
@ViewScoped
public class CadastroPlanoDeVooBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroPlanoDeVooService cadastroPlanoDeVooService;
    
    @Inject
    private Aerodromos aerodromos;
    
    @Inject
    private Aeronaves aeronaves;
    
    @Produces
    private PlanoDeVoo planoDeVoo;
    private Trecho trechoNovo;
    
    private List<Aeronave> listaAeronaves;
    private List<MedidaCombustivel> medidasCombustivel;
    private List<TipoRegraVoo> regrasVoo;
    private List<PeriodoVoo> periodosVoo;
    private String auxTrechoDestino;

    public CadastroPlanoDeVooBean() {
        limpar();
    }

    public void inicializar() {
        if (this.planoDeVoo == null) {
            limpar();
        }
        this.listaAeronaves = aeronaves.todos();
        this.medidasCombustivel = Arrays.asList(MedidaCombustivel.values());
        this.regrasVoo = Arrays.asList(TipoRegraVoo.values());
        this.periodosVoo = Arrays.asList(PeriodoVoo.values());
    }

    public PlanoDeVoo getPlanoDeVoo() {
        return planoDeVoo;
    }

    public void setPlanoDeVoo(PlanoDeVoo planoDeVoo) {
        this.planoDeVoo = planoDeVoo;
    }
    
	public List<Aeronave> getListaAeronaves() {
		return listaAeronaves;
	}

	public List<MedidaCombustivel> getMedidasCombustivel() {
		return medidasCombustivel;
	}

	public List<TipoRegraVoo> getRegrasVoo() {
		return regrasVoo;
	}

	public List<PeriodoVoo> getPeriodosVoo() {
		return periodosVoo;
	}

	public Trecho getTrechoNovo() {
		return trechoNovo;
	}

	public void setTrechoNovo(Trecho trechoNovo) {
		this.trechoNovo = trechoNovo;
	}

	private void limpar() {
        this.planoDeVoo = new PlanoDeVoo();
        this.planoDeVoo.setCalculoPeso(new CalculoPeso());
        this.planoDeVoo.setRegraVoo(new RegraVoo());
        this.planoDeVoo.getCalculoPeso().setPesoMedioBagagens(35);
        this.planoDeVoo.getCalculoPeso().setPesoMedioTripulantes(70);
        
        this.trechoNovo = new Trecho();
    }

    public void salvar() {
        try {
            this.planoDeVoo = cadastroPlanoDeVooService.salvar(planoDeVoo);
            limpar();
            
            FacesUtil.addInfoMessage("Plano de voo salvo com sucesso!");
        } catch (NegocioException ne) {
            FacesUtil.addErrorMessage(ne.getMessage());
        }
    }

    public List<Aerodromo> completarAerodromo(String query){
    	return aerodromos.porIcaoComecadoEm(query);
    }
    
    public boolean isEditando() {
        return this.planoDeVoo.getId() != null;
    }
    
    public void preparaNovoTrecho(){
    	this.trechoNovo = new Trecho();
    	this.trechoNovo.setPlanoDeVoo(planoDeVoo);
    	if(planoDeVoo.getOrigem() != null && planoDeVoo.getRota().size() == 0){
    		this.trechoNovo.setOrigem(planoDeVoo.getOrigem().getIcao());
    	} else {
    		this.trechoNovo.setOrigem(auxTrechoDestino);
    	}
    }
    
    public void adicionarTrechoRota() {
    	try {
	    	int alt = this.trechoNovo.retornaAltitudeInteira();
	    	double a = alt/1000;
	    	Long aux = Math.round(a);
	    	alt = Integer.valueOf(aux.intValue());
	    	if (RegraParImpar.PAR.equals(this.trechoNovo.getRegraPI())) {
	    		if(alt % 2 != 0 && !this.trechoNovo.getRea()) {
	    			throw new NegocioException("Altitude ou Nível de Voo incorreta! Ela deve ser par!");
	    		}
	    	}else {
	    		if(alt % 2 == 0 && !this.trechoNovo.getRea()) {
	    			throw new NegocioException("Altitude ou Nível de Voo incorreta! Ela deve ser impar!");
	    		}
	    	}
	    	this.auxTrechoDestino = this.trechoNovo.getDestino();
	    	this.planoDeVoo.adicionarTrechoRota(trechoNovo);
	    	FacesUtil.addInfoMessage("Trecho adicionado com sucesso!");
	    	preparaNovoTrecho();
	    } catch (NegocioException ne) {
	    	FacesUtil.addErrorMessage(ne.getMessage());
	    }
    } 
    
    public void verificaRegraPI() {
    	this.trechoNovo.defineRegraParImpar();
    }
}
