package br.rennan.goldplanning.model;

public enum PeriodoVoo {
	
	DIURNO("Diurno"), NOTURNO("Noturno");
	
	private String descricao;

	PeriodoVoo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
