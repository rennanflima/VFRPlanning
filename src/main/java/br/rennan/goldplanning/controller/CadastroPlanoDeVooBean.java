/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.controller;

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

import br.rennan.goldplanning.model.Aerodromo;
import br.rennan.goldplanning.model.Aeronave;
import br.rennan.goldplanning.model.CalculoPeso;
import br.rennan.goldplanning.model.MedidaCombustivel;
import br.rennan.goldplanning.model.PeriodoVoo;
import br.rennan.goldplanning.model.PlanoDeVoo;
import br.rennan.goldplanning.model.RegraVoo;
import br.rennan.goldplanning.model.TipoRegraVoo;
import br.rennan.goldplanning.model.Trecho;
import br.rennan.goldplanning.repository.Aerodromos;
import br.rennan.goldplanning.repository.Aeronaves;
import br.rennan.goldplanning.service.CadastroPlanoDeVooService;
import br.rennan.goldplanning.service.NegocioException;
import br.rennan.goldplanning.util.jsf.FacesUtil;

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
    	this.auxTrechoDestino = this.trechoNovo.getDestino();
    	this.planoDeVoo.adicionarTrechoRota(trechoNovo);
    	FacesUtil.addInfoMessage("Trecho adicionado com sucesso!");
    	preparaNovoTrecho();
    } 
}
