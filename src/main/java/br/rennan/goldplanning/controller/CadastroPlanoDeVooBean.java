/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.rennan.goldplanning.model.Aerodromo;
import br.rennan.goldplanning.model.Aeronave;
import br.rennan.goldplanning.model.PlanoDeVoo;
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
    
    private List<Aeronave> listaAeronaves;

    public CadastroPlanoDeVooBean() {
        limpar();
    }

    public void inicializar() {
        if (this.planoDeVoo == null) {
            limpar();
        }
        this.listaAeronaves = aeronaves.todos();
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

	private void limpar() {
        this.planoDeVoo = new PlanoDeVoo();
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

}
