/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplaning.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rennan.lima
 */
@Entity
public class Trecho {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String origem;
    @NotNull
    @Column(nullable = false)
    private String destino;
    @NotNull
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal distancia;
    @NotNull
    @Column(name = "rumo_magnetico", nullable = false)
    private Integer rumoMagnetico;
    @NotNull
    @Column(name = "velocidade_indicada", nullable = false)
    private Integer velocidadeIndicada;
    @NotNull
    @Column(nullable = false)
    private String altitude;
    @Column(name = "direcao_vento_voo")
    private Integer direcaoVentoVoo;
    @Column(name = "velocidade_vento_voo")
    private Integer velocidadeVentoVoo;
    @Column(name = "velocidade_solo")
    private Integer velocidadeSolo;
    @Column(name = "duracao_estimada_trecho", nullable = false)
    private LocalTime duracaoEstimadaTrecho;
    @Column(name = "hora_estimada_sobrevoo")
    private LocalTime horaEstimadaSobrevoo;
    @Column(precision = 10, scale = 2)
    private BigDecimal combustivel = BigDecimal.ZERO;
    @Column(columnDefinition = "text")
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "plano_de_voo_id", nullable = false)
    private PlanoDeVoo planoDeVoo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getTrecho() {
        return destino;
    }

    public void setTrecho(String destino) {
        this.destino = destino;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    public Integer getRumoMagnetico() {
        return rumoMagnetico;
    }

    public void setRumoMagnetico(Integer rumoMagnetico) {
        this.rumoMagnetico = rumoMagnetico;
    }

    public Integer getVelocidadeIndicada() {
        return velocidadeIndicada;
    }

    public void setVelocidadeIndicada(Integer velocidadeIndicada) {
        this.velocidadeIndicada = velocidadeIndicada;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public Integer getDirecaoVentoVoo() {
        return direcaoVentoVoo;
    }

    public void setDirecaoVentoVoo(Integer direcaoVentoVoo) {
        this.direcaoVentoVoo = direcaoVentoVoo;
    }

    public Integer getVelocidadeVentoVoo() {
        return velocidadeVentoVoo;
    }

    public void setVelocidadeVentoVoo(Integer velocidadeVentoVoo) {
        this.velocidadeVentoVoo = velocidadeVentoVoo;
    }

    public Integer getVelocidadeSolo() {
        return velocidadeSolo;
    }

    public void setVelocidadeSolo(Integer velocidadeSolo) {
        this.velocidadeSolo = velocidadeSolo;
    }

    public LocalTime getDuracaoEstimadaTrecho() {
        return duracaoEstimadaTrecho;
    }

    public void setDuracaoEstimadaTrecho(LocalTime duracaoEstimadaTrecho) {
        this.duracaoEstimadaTrecho = duracaoEstimadaTrecho;
    }

    public LocalTime getHoraEstimadaSobrevoo() {
        return horaEstimadaSobrevoo;
    }

    public void setHoraEstimadaSobrevoo(LocalTime horaEstimadaSobrevoo) {
        this.horaEstimadaSobrevoo = horaEstimadaSobrevoo;
    }

    public BigDecimal getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(BigDecimal combustivel) {
        this.combustivel = combustivel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public PlanoDeVoo getPlanoDeVoo() {
        return planoDeVoo;
    }

    public void setPlanoDeVoo(PlanoDeVoo planoDeVoo) {
        this.planoDeVoo = planoDeVoo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Trecho other = (Trecho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
