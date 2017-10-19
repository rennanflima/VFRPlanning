/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.rennan.vfrplanning.model.Aerodromo;
import br.rennan.vfrplanning.model.Aeronave;
import br.rennan.vfrplanning.repository.Aerodromos;
import br.rennan.vfrplanning.repository.Aeronaves;
import br.rennan.vfrplanning.repository.filter.AerodromoFilter;
import br.rennan.vfrplanning.service.NegocioException;
import br.rennan.vfrplanning.util.jsf.FacesUtil;

/**
 *
 * @author rennan.lima
 */
@Named
@ViewScoped
public class PesquisaAeronavesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Aeronaves aeronaves;

    private List<Aeronave> aeronavesFiltradas;

    private Aeronave aeronaveSelecionada;

    public PesquisaAeronavesBean() {
    }
    
    public void inicializar() {
    	pesquisar();
    }

    public void excluir() {
        try {
            aeronaves.remover(aeronaveSelecionada);
            aeronavesFiltradas.remove(aeronaveSelecionada);

            FacesUtil.addInfoMessage("Aerodromo " + aeronaveSelecionada.getIcao()
                    + " excluído com sucesso.");
        } catch (NegocioException ne) {
            FacesUtil.addErrorMessage(ne.getMessage());
        }
    }

    public void pesquisar() {
        aeronavesFiltradas = aeronaves.todos();
    }

	public List<Aeronave> getAeronavesFiltradas() {
		return aeronavesFiltradas;
	}

	public void setAeronavesFiltradas(List<Aeronave> aeronavesFiltradas) {
		this.aeronavesFiltradas = aeronavesFiltradas;
	}

	public Aeronave getAeronaveSelecionada() {
		return aeronaveSelecionada;
	}

	public void setAeronaveSelecionada(Aeronave aeronaveSelecionada) {
		this.aeronaveSelecionada = aeronaveSelecionada;
	}



}
