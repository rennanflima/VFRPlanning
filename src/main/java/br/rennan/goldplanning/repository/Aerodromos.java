/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.rennan.goldplanning.model.Aerodromo;
import br.rennan.goldplanning.repository.filter.AerodromoFilter;
import br.rennan.goldplanning.service.NegocioException;
import br.rennan.goldplanning.util.jpa.Transactional;

/**
 *
 * @author rennan.lima
 */
public class Aerodromos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Aerodromo guardar(Aerodromo aerodromo) {
        return manager.merge(aerodromo);
    }

    @Transactional
    public void remover(Aerodromo aerodromo) {
        try {
            aerodromo = porId(aerodromo.getId());
            manager.remove(aerodromo);
            manager.flush();
        } catch (PersistenceException e) {
            throw new NegocioException("Aerodromo não pode ser excluído.");
        }
    }

    public Aerodromo porIcao(String icao) {
        try {
            return manager.createQuery("from Aerodromo where upper(icao) = :icao", Aerodromo.class)
                    .setParameter("icao", icao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Aerodromo> filtrados(AerodromoFilter filtro) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Aerodromo.class);

        if (StringUtils.isNotBlank(filtro.getIcao())) {
            criteria.add(Restrictions.eq("icao", filtro.getIcao()));
        }

        if (StringUtils.isNotBlank(filtro.getNome())) {
            criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("nome")).list();
    }

    public Aerodromo porId(Long id) {
        return manager.find(Aerodromo.class, id);
    }

    public List<Aerodromo> porNome(String nome) {
        return this.manager.createQuery("from Aerodromo where upper(aeronave) like :nome", Aerodromo.class)
                .setParameter("nome", nome.toUpperCase() + "%").getResultList();
    }

}
