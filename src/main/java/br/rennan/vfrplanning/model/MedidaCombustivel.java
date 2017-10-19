/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.model;

/**
 *
 * @author rennan.lima
 */
public enum MedidaCombustivel {

	KILOGRAMAS("Kilogramas (kg)"), LITROS("Litros (L)"), GALAO("Galão (Gal)"), POUNDS("Pounds (ibs)");

	private String descricao;

	MedidaCombustivel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
