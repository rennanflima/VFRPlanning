package br.rennan.vfrplanning.model;

public enum TipoAeronave {
	
	HELICOPTERO("Helicópteros"), AVIOES_JATO("Aviões a Jato"), AVIOES_HELICE("Aviões a Hélice");
	
	private String descricao;

	TipoAeronave(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
