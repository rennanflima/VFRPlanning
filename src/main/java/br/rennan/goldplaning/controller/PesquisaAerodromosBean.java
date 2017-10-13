/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplaning.controller;

import br.rennan.goldplaning.model.Aerodromo;
import br.rennan.goldplaning.repository.Aerodromos;
import br.rennan.goldplaning.repository.filter.AerodromoFilter;
import br.rennan.goldplaning.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
        aerodromos.remover(aerodromoSelecionado);
        aerodromosFiltrados.remove(aerodromoSelecionado);

        FacesUtil.addInfoMessage("Aerodromo " + aerodromoSelecionado.getIcao()
                + " excluído com sucesso.");
    }

    public void pesquisar() {
        aerodromosFiltrados = aerodromos.filtrados(filtro);
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
