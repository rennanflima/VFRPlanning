/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplaning.service;

import br.rennan.goldplaning.model.Aerodromo;
import br.rennan.goldplaning.repository.Aerodromos;
import br.rennan.goldplaning.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author rennan.lima
 */
public class CadastroAerodromoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Aerodromos aerodromos;

    @Transactional
    public Aerodromo salvar(Aerodromo aerodromo) {
        Aerodromo aerodromoExistente = aerodromos.porIcao(aerodromo.getIcao());
        
        if(aerodromoExistente != null && !aerodromoExistente.equals(aerodromo)){
            throw new NegocioException("Já existe um aerodromo com o ICAO informado.");
        }
        
        return aerodromos.guardar(aerodromo);
    }
}
