/*
	 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.service;

import br.rennan.goldplanning.model.Aeronave;
import br.rennan.goldplanning.repository.Aeronaves;
import br.rennan.goldplanning.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author rennan.lima
 */
public class CadastroAeronaveService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Aeronaves aeronaves;

    @Transactional
    public Aeronave salvar(Aeronave aeronave) throws NegocioException {
    	Aeronave aeronaveExistente = aeronaves.porIcao(aeronave.getIcao());

        if (aeronaveExistente != null && !aeronaveExistente.equals(aeronave)) {
            throw new NegocioException("Já existe um aeronave com o ICAO informado.");
        }

        return aeronaves.guardar(aeronave);
    }
}
