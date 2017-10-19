/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.vfrplanning.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.rennan.vfrplanning.model.PlanoDeVoo;
import br.rennan.vfrplanning.repository.PlanosDeVoo;

/**
 *
 * @author rennan.lima
 */
@FacesConverter(forClass = PlanoDeVoo.class)
public class PlanoDeVooConverter implements Converter {

    @Inject
    private PlanosDeVoo aeronaves;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	PlanoDeVoo retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Long id = new Long(value);
            retorno = aeronaves.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
        	PlanoDeVoo planoDeVoo = (PlanoDeVoo) value;
            return planoDeVoo.getId() == null ? null : planoDeVoo.getId().toString();
        }

        return "";
    }

}
