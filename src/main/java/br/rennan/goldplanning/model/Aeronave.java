/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author rennan.lima
 */
@Entity
public class Aeronave implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String aeronave;
    private String tipo;
    @NotBlank
    @Column(unique = true)
    private String icao;
    @Column(name = "esteira_turbulencia")
    private String esteiraTurbulencia;
    @Column(name = "consumo_litro_hora", precision = 10, scale = 2)
    private BigDecimal consumoLitroHora = BigDecimal.ZERO;
    @Column(name = "capacidade_combustivel", precision = 10, scale = 2)
    private BigDecimal capacidadeCombustivel = BigDecimal.ZERO;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_capacidade_combustivel", nullable = false, length = 20)
    private TipoCapacidade tipoCapacidadeCombustivel;
    @Column(name = "peso_vazio", precision = 10, scale = 2)
    private BigDecimal pesoVazio = BigDecimal.ZERO;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoPeso tipoPesoVazio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getEsteiraTurbulencia() {
        return esteiraTurbulencia;
    }

    public void setEsteiraTurbulencia(String esteiraTurbulencia) {
        this.esteiraTurbulencia = esteiraTurbulencia;
    }

    public BigDecimal getConsumoLitroHora() {
        return consumoLitroHora;
    }

    public void setConsumoLitroHora(BigDecimal consumoLitroHora) {
        this.consumoLitroHora = consumoLitroHora;
    }

    public BigDecimal getCapacidadeCombustivel() {
        return capacidadeCombustivel;
    }

    public void setCapacidadeCombustivel(BigDecimal capacidadeCombustivel) {
        this.capacidadeCombustivel = capacidadeCombustivel;
    }

    public TipoCapacidade getTipoCapacidadeCombustivel() {
        return tipoCapacidadeCombustivel;
    }

    public void setTipoCapacidadeCombustivel(TipoCapacidade tipoCapacidadeCombustivel) {
        this.tipoCapacidadeCombustivel = tipoCapacidadeCombustivel;
    }

    public BigDecimal getPesoVazio() {
        return pesoVazio;
    }

    public void setPesoVazio(BigDecimal pesoVazio) {
        this.pesoVazio = pesoVazio;
    }

    public TipoPeso getTipoPesoVazio() {
        return tipoPesoVazio;
    }

    public void setTipoPesoVazio(TipoPeso tipoPesoVazio) {
        this.tipoPesoVazio = tipoPesoVazio;
    }
    
    @Transient
    public String getTipoIcaoEst_Turb(){
    	return this.tipo+"/"+this.icao+"/"+this.esteiraTurbulencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Aeronave other = (Aeronave) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
