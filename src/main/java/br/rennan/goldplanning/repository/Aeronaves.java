package br.rennan.goldplanning.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import br.rennan.goldplanning.model.Aerodromo;
import br.rennan.goldplanning.model.Aeronave;
import br.rennan.goldplanning.service.NegocioException;
import br.rennan.goldplanning.util.jpa.Transactional;

public class Aeronaves implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;
    
    public Aeronave guardar(Aeronave aeronave) {
        return manager.merge(aeronave);
    }

    @Transactional
    public void remover(Aeronave aeronave) {
        try {
            aeronave = porId(aeronave.getId());
            manager.remove(aeronave);
            manager.flush();
        } catch (PersistenceException e) {
            throw new NegocioException("Aerodromo não pode ser excluído.");
        }
    }

    public Aeronave porId(Long id) {
        return manager.find(Aeronave.class, id);
    }
    
    public List<Aeronave> porNome(String nome) {
        return this.manager.createQuery("from Aeronave where upper(aeronave) like :nome", Aeronave.class)
                .setParameter("nome", nome.toUpperCase() + "%").getResultList();
    }
    
    public List<Aeronave> todos() {
    	return manager.createQuery("from Aeronave", 
    			Aeronave.class).getResultList();
    }
    
    public Aeronave porIcao(String icao) {
        try {
            return manager.createQuery("from Aeronave where upper(icao) = :icao", Aeronave.class)
                    .setParameter("icao", icao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
