/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.rennan.goldplanning.model.Aeronave;
import br.rennan.goldplanning.model.TipoCapacidade;
import br.rennan.goldplanning.model.TipoPeso;
import br.rennan.goldplanning.service.CadastroAeronaveService;
import br.rennan.goldplanning.service.NegocioException;
import br.rennan.goldplanning.util.jsf.FacesUtil;

/**
 *
 * @author rennan.lima
 */
@Named
@ViewScoped
public class CadastroAeronaveBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroAeronaveService cadastroAeronaveService;

    private Aeronave aeronave;
    private List<TipoCapacidade> tiposCapacidades;
    private List<TipoPeso> tiposPesos;

    public CadastroAeronaveBean() {
        limpar();
    }

    public void inicializar() {
        if (this.aeronave == null) {
            limpar();
        }
        this.tiposPesos = Arrays.asList(TipoPeso.values());
        this.tiposCapacidades = Arrays.asList(TipoCapacidade.values());
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public List<TipoCapacidade> getTiposCapacidades() {
		return tiposCapacidades;
	}

	public List<TipoPeso> getTiposPesos() {
		return tiposPesos;
	}

	private void limpar() {
        this.aeronave = new Aeronave();
    }

    public void salvar() {
        try {
            this.aeronave = cadastroAeronaveService.salvar(aeronave);
            limpar();
            
            FacesUtil.addInfoMessage("Aeronave salva com sucesso!");
        } catch (NegocioException ne) {
            FacesUtil.addErrorMessage(ne.getMessage());
        }
    }

    public boolean isEditando() {
        return this.aeronave.getId() != null;
    }

}
