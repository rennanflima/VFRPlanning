/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.rennan.goldplanning.model.Aerodromo;
import br.rennan.goldplanning.service.CadastroAerodromoService;
import br.rennan.goldplanning.service.NegocioException;
import br.rennan.goldplanning.util.jsf.FacesUtil;

/**
 *
 * @author rennan.lima
 */
@Named
@ViewScoped
public class CadastroAerodromoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroAerodromoService cadastroAerodromoService;

    private Aerodromo aerodromo;

    public CadastroAerodromoBean() {
        limpar();
    }

    public void inicializar() {
        if (this.aerodromo == null) {
            limpar();
        }
    }

    public Aerodromo getAerodromo() {
        return aerodromo;
    }

    public void setAerodromo(Aerodromo aerodromo) {
        this.aerodromo = aerodromo;
    }

    private void limpar() {
        this.aerodromo = new Aerodromo();
    }

    public void salvar() {
        try {
            this.aerodromo = cadastroAerodromoService.salvar(aerodromo);
            limpar();
            
            FacesUtil.addInfoMessage("Aerodromo salvo com sucesso!");
        } catch (NegocioException ne) {
            FacesUtil.addErrorMessage(ne.getMessage());
        }
    }

    public boolean isEditando() {
        return this.aerodromo.getId() != null;
    }

}
