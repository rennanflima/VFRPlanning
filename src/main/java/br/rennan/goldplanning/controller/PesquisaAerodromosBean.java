/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.rennan.goldplanning.model.Aerodromo;
import br.rennan.goldplanning.repository.Aerodromos;
import br.rennan.goldplanning.repository.filter.AerodromoFilter;
import br.rennan.goldplanning.service.NegocioException;
import br.rennan.goldplanning.util.jsf.FacesUtil;

/**
 *
 * @author rennan.lima
 */
@Named
@ViewScoped
public class PesquisaAerodromosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Aerodromos aerodromos;

    private AerodromoFilter filtro;
    private List<Aerodromo> aerodromosFiltrados;

    private Aerodromo aerodromoSelecionado;

    public PesquisaAerodromosBean() {
        filtro = new AerodromoFilter();
    }

    public void excluir() {
        try {
            aerodromos.remover(aerodromoSelecionado);
            aerodromosFiltrados.remove(aerodromoSelecionado);

            FacesUtil.addInfoMessage("Aerodromo " + aerodromoSelecionado.getIcao()
                    + " excluído com sucesso.");
        } catch (NegocioException ne) {
            FacesUtil.addErrorMessage(ne.getMessage());
        }
    }

    public void pesquisar() {
        aerodromosFiltrados = aerodromos.filtrados(filtro);
        System.out.println(aerodromosFiltrados.size());
    }

    public AerodromoFilter getFiltro() {
        return filtro;
    }

    public void setFiltro(AerodromoFilter filtro) {
        this.filtro = filtro;
    }

    public List<Aerodromo> getAerodromosFiltrados() {
        return aerodromosFiltrados;
    }

    public void setAerodromosFiltrados(List<Aerodromo> aerodromosFiltrados) {
        this.aerodromosFiltrados = aerodromosFiltrados;
    }

    public Aerodromo getAerodromoSelecionado() {
        return aerodromoSelecionado;
    }

    public void setAerodromoSelecionado(Aerodromo aerodromoSelecionado) {
        this.aerodromoSelecionado = aerodromoSelecionado;
    }

}
