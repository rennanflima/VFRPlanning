/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author rennan.lima
 */
@Entity
public class Aerodromo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Column(nullable = false, length = 20, unique = true)
    private String icao;
    private String nome;
    private String municipio;
    private int elevacao;
    private int cabeceira1;
    private int cabeceira2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getElevacao() {
        return elevacao;
    }

    public void setElevacao(int elevacao) {
        this.elevacao = elevacao;
    }

    public int getCabeceira1() {
        return cabeceira1;
    }

    public void setCabeceira1(int cabeceira1) {
        this.cabeceira1 = cabeceira1;
    }

    public int getCabeceira2() {
        return cabeceira2;
    }

    public void setCabeceira2(int cabeceira2) {
        this.cabeceira2 = cabeceira2;
    }
    
    @Transient
    public String getNomeAeroporto() {
    	return this.nome+" ("+this.municipio+")";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aerodromo other = (Aerodromo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
