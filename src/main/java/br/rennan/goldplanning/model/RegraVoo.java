package br.rennan.goldplanning.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class RegraVoo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_regra_voo", nullable=false)
	private TipoRegraVoo tipoRegraVoo;
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="medida_combustivel", nullable=false)
	private MedidaCombustivel medidaCombustivel;
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name="periodo_voo", nullable=false)
	private PeriodoVoo periodoVoo;
	@NotNull
	@Column(name="contingencia_operacao_solo", nullable=false)
	private Boolean contingenciaOperacaoSolo;
	
	public TipoRegraVoo getTipoRegraVoo() {
		return tipoRegraVoo;
	}
	
	public void setTipoRegraVoo(TipoRegraVoo tipoRegraVoo) {
		this.tipoRegraVoo = tipoRegraVoo;
	}
	
	public MedidaCombustivel getMedidaCombustivel() {
		return medidaCombustivel;
	}
	
	public void setMedidaCombustivel(MedidaCombustivel medidaCombustivel) {
		this.medidaCombustivel = medidaCombustivel;
	}
	
	public PeriodoVoo getPeriodoVoo() {
		return periodoVoo;
	}
	
	public void setPeriodoVoo(PeriodoVoo periodoVoo) {
		this.periodoVoo = periodoVoo;
	}
	
	public Boolean getContingenciaOperacaoSolo() {
		return contingenciaOperacaoSolo;
	}

	public void setContingenciaOperacaoSolo(Boolean contingenciaOperacaoSolo) {
		this.contingenciaOperacaoSolo = contingenciaOperacaoSolo;
	}
	
}
