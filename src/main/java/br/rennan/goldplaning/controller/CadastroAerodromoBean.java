/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplaning.controller;

import br.rennan.goldplaning.model.Aerodromo;
import br.rennan.goldplaning.service.CadastroAerodromoService;
import br.rennan.goldplaning.util.jsf.FacesUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

    private Aerodromo aerodromo = new Aerodromo();

    public CadastroAerodromoBean() {
        limpar();
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
        this.aerodromo = cadastroAerodromoService.salvar(aerodromo);
        limpar();

        FacesUtil.addInfoMessage("Aerodromo salvo com sucesso!");
    }

    public boolean isEditando() {
        return this.aerodromo.getId() != null;
    }

}
