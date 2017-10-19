package br.rennan.vfrplanning.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import br.rennan.vfrplanning.model.PlanoDeVoo;
import br.rennan.vfrplanning.service.NegocioException;
import br.rennan.vfrplanning.util.jpa.Transactional;

public class PlanosDeVoo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;
    
    public PlanoDeVoo guardar(PlanoDeVoo planoDeVoo) {
        return manager.merge(planoDeVoo);
    }

    @Transactional
    public void remover(PlanoDeVoo planoDeVoo) {
        try {
            planoDeVoo = porId(planoDeVoo.getId());
            manager.remove(planoDeVoo);
            manager.flush();
        } catch (PersistenceException e) {
            throw new NegocioException("Plano de Voo não pode ser excluído.");
        }
    }

    public PlanoDeVoo porId(Long id) {
        return manager.find(PlanoDeVoo.class, id);
    }
    
    public List<PlanoDeVoo> porNome(String nome) {
        return this.manager.createQuery("from PlanoDeVoo where upper(aeronave) like :nome", PlanoDeVoo.class)
                .setParameter("nome", nome.toUpperCase() + "%").getResultList();
    }
    
    public List<PlanoDeVoo> todos() {
    	return manager.createQuery("from PlanoDeVoo", 
    			PlanoDeVoo.class).getResultList();
    }

}
