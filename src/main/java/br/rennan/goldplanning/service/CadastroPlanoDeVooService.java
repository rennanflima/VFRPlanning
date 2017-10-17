/*
	 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.service;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.inject.Inject;

import br.rennan.goldplanning.model.PlanoDeVoo;
import br.rennan.goldplanning.repository.PlanosDeVoo;
import br.rennan.goldplanning.util.jpa.Transactional;

/**
 *
 * @author rennan.lima
 */
public class CadastroPlanoDeVooService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PlanosDeVoo planosDeVoo;

    @Transactional
    public PlanoDeVoo salvar(PlanoDeVoo planoDeVoo) throws NegocioException {
    	if (planoDeVoo.isNovo()) {
    		planoDeVoo.setDataCriacao(LocalDateTime.now());
    	}

    	planoDeVoo = this.planosDeVoo.guardar(planoDeVoo);
		return planoDeVoo;
    }
}
