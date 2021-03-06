/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rennan.lima
 */
@Entity
public class PlanoDeVoo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private Aeronave aeronave;
    @NotNull
    @Column(nullable = false)
    private Aerodromo origem;
    @NotNull
    @Column(nullable = false)
    private Aerodromo destino;
    @NotNull
    @Column(nullable = false)
    private Aerodromo alternativo;
    @Embedded
    private CalculoPeso calculoPeso;
    @Embedded
    private RegraVoo regraVoo;
    @OneToMany(mappedBy = "planoDeVoo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Trecho> rota = new ArrayList<>();
    private LocalDateTime dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Aerodromo getOrigem() {
        return origem;
    }

    public void setOrigem(Aerodromo origem) {
        this.origem = origem;
    }

    public Aerodromo getDestino() {
        return destino;
    }

    public void setDestino(Aerodromo destino) {
        this.destino = destino;
    }

    public Aerodromo getAlternativo() {
        return alternativo;
    }

    public void setAlternativo(Aerodromo alternativo) {
        this.alternativo = alternativo;
    }

    public CalculoPeso getCalculoPeso() {
		return calculoPeso;
	}

	public void setCalculoPeso(CalculoPeso calculoPeso) {
		this.calculoPeso = calculoPeso;
	}

	public RegraVoo getRegraVoo() {
		return regraVoo;
	}

	public void setRegraVoo(RegraVoo regraVoo) {
		this.regraVoo = regraVoo;
	}

	public List<Trecho> getRota() {
        return rota;
    }

    public void setRota(List<Trecho> rota) {
        this.rota = rota;
    }
    
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Transient
	public boolean isNovo() {
		return getId() == null;
	}
	
	@Transient
	public boolean isExistente() {
		return !isNovo();
	}
	
	@Transient
	public boolean isNaoTemAerodromoOrigem() {
		return getOrigem() == null;
	}
	
	public void adicionarTrechoRota(Trecho trecho) {
		trecho.calcularVelocidadeAerodinamica();
		trecho.calcularVelocidadeSolo();
		trecho.calcularHoraEstimadaSobrevoo();
		this.rota.add(trecho);
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final PlanoDeVoo other = (PlanoDeVoo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
