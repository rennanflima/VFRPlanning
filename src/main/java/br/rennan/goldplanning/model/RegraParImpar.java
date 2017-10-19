package br.rennan.goldplanning.model;

public enum RegraParImpar {
	
	PAR("Par"), IMPAR("Impar");
	
	private String descricao;

	RegraParImpar(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
