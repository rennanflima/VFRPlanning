/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Aeronave implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String nome;
    private String tipo;
    @NotBlank
    @Column(unique = true)
    private String icao;
    @Column(name = "esteira_turbulencia")
    private String esteiraTurbulencia;
    @Column(name = "consumo_hora", precision = 10, scale = 2)
    private BigDecimal consumoHora = BigDecimal.ZERO;
    @Column(name = "capacidade_combustivel", precision = 10, scale = 2)
    private BigDecimal capacidadeCombustivel = BigDecimal.ZERO;
    @Column(name = "peso_vazio", precision = 10, scale = 2)
    private BigDecimal pesoVazio = BigDecimal.ZERO;
    @Column(precision = 10, scale = 2)
    private BigDecimal comprimento = BigDecimal.ZERO;
    @Column(precision = 10, scale = 2)
    private BigDecimal envergadura = BigDecimal.ZERO;
    @Column(precision = 10, scale = 2)
    private BigDecimal altura = BigDecimal.ZERO;
    private Integer passageiros;
    @Column(name = "peso_maximo_decolagem",precision = 10, scale = 2)
    private BigDecimal pesoMaximoDecolagem = BigDecimal.ZERO;
    @Column(name = "peso_maximo_pouso",precision = 10, scale = 2)
    private BigDecimal pesoMaximoPouso = BigDecimal.ZERO;
    @Column(name = "carga_máxima_com_passageiros",precision = 10, scale = 2)
    private BigDecimal cargaMáximaComPassageiros = BigDecimal.ZERO;
    @Column(name = "pista_com_peso_maximo_alta_temperatura")
    private Integer pistaComPesoMaximoAltaTemperatura;
    @Column(name = "velocidade_cruzeiro")
    private Integer velocidadeCruzeiro;
    @Column(name = "velocidade_minima")
    private Integer velocidadeMinima;
    private Integer autonomia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public BigDecimal getConsumoHora() {
        return consumoHora;
    }

    public void setConsumoHora(BigDecimal consumoHora) {
        this.consumoHora = consumoHora;
    }

    public BigDecimal getCapacidadeCombustivel() {
        return capacidadeCombustivel;
    }

    public void setCapacidadeCombustivel(BigDecimal capacidadeCombustivel) {
        this.capacidadeCombustivel = capacidadeCombustivel;
    }

    public BigDecimal getPesoVazio() {
        return pesoVazio;
    }

    public void setPesoVazio(BigDecimal pesoVazio) {
        this.pesoVazio = pesoVazio;
    }

    
    
    public BigDecimal getComprimento() {
		return comprimento;
	}

	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}

	public BigDecimal getEnvergadura() {
		return envergadura;
	}

	public void setEnvergadura(BigDecimal envergadura) {
		this.envergadura = envergadura;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public Integer getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(Integer passageiros) {
		this.passageiros = passageiros;
	}

	public BigDecimal getPesoMaximoDecolagem() {
		return pesoMaximoDecolagem;
	}

	public void setPesoMaximoDecolagem(BigDecimal pesoMaximoDecolagem) {
		this.pesoMaximoDecolagem = pesoMaximoDecolagem;
	}

	public BigDecimal getPesoMaximoPouso() {
		return pesoMaximoPouso;
	}

	public void setPesoMaximoPouso(BigDecimal pesoMaximoPouso) {
		this.pesoMaximoPouso = pesoMaximoPouso;
	}

	public BigDecimal getCargaMáximaComPassageiros() {
		return cargaMáximaComPassageiros;
	}

	public void setCargaMáximaComPassageiros(BigDecimal cargaMáximaComPassageiros) {
		this.cargaMáximaComPassageiros = cargaMáximaComPassageiros;
	}

	public Integer getPistaComPesoMaximoAltaTemperatura() {
		return pistaComPesoMaximoAltaTemperatura;
	}

	public void setPistaComPesoMaximoAltaTemperatura(Integer pistaComPesoMaximoAltaTemperatura) {
		this.pistaComPesoMaximoAltaTemperatura = pistaComPesoMaximoAltaTemperatura;
	}

	public Integer getVelocidadeCruzeiro() {
		return velocidadeCruzeiro;
	}

	public void setVelocidadeCruzeiro(Integer velocidadeCruzeiro) {
		this.velocidadeCruzeiro = velocidadeCruzeiro;
	}

	
	public Integer getVelocidadeMinima() {
		return velocidadeMinima;
	}

	public void setVelocidadeMinima(Integer velocidadeMinima) {
		this.velocidadeMinima = velocidadeMinima;
	}

	public Integer getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(Integer autonomia) {
		this.autonomia = autonomia;
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
