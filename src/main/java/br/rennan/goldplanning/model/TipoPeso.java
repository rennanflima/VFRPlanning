/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.model;

/**
 *
 * @author rennan.lima
 */
public enum TipoPeso {
    
    KILO("kg");
	
	private String descricao;

	TipoPeso(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}


}
