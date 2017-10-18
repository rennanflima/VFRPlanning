package br.rennan.goldplanning.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class CalculoPeso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Column(name = "quantidade_passageiros", nullable = false)
	private Integer quantidadePassageiros;
	@Column(name = "peso_medio_tripulantes")
	private Integer pesoMedioTripulantes;
	@NotNull
	@Column(name = "peso_medio_bagagens", nullable = false)
	private Integer pesoMedioBagagens;
	@Column(name = "peso_combustivel")
	private Integer pesoCombustivel;
	private Integer ZFW;
	
	public Integer getQuantidadePassageiros() {
		return quantidadePassageiros;
	}
	public void setQuantidadePassageiros(Integer quantidadePassageiros) {
		this.quantidadePassageiros = quantidadePassageiros;
	}
	public Integer getPesoMedioTripulantes() {
		return pesoMedioTripulantes;
	}
	public void setPesoMedioTripulantes(Integer pesoMedioTripulantes) {
		this.pesoMedioTripulantes = pesoMedioTripulantes;
	}
	public Integer getPesoMedioBagagens() {
		return pesoMedioBagagens;
	}
	public void setPesoMedioBagagens(Integer pesoMedioBagagens) {
		this.pesoMedioBagagens = pesoMedioBagagens;
	}
	public Integer getPesoCombustivel() {
		return pesoCombustivel;
	}
	public void setPesoCombustivel(Integer pesoCombustivel) {
		this.pesoCombustivel = pesoCombustivel;
	}
	public Integer getZFW() {
		return ZFW;
	}
	public void setZFW(Integer zFW) {
		ZFW = zFW;
	}
	
	

}
