/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.rennan.vfrplanning.model.Aeronave;
import br.rennan.vfrplanning.service.CadastroAeronaveService;
import br.rennan.vfrplanning.service.NegocioException;
import br.rennan.vfrplanning.util.jsf.FacesUtil;

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

    public CadastroAeronaveBean() {
        limpar();
    }

    public void inicializar() {
        if (this.aeronave == null) {
            limpar();
        }
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
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
