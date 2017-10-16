/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.repository.filter;

import java.io.Serializable;

/**
 *
 * @author rennan.lima
 */
public class AerodromoFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String icao;
    private String nome;

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
