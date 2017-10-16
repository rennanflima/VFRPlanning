/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.converter;

import br.rennan.goldplanning.model.Aeronave;
import br.rennan.goldplanning.repository.Aeronaves;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author rennan.lima
 */
@FacesConverter(forClass = Aeronave.class)
public class AeronaveConverter implements Converter {

    @Inject
    private Aeronaves aeronaves;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Aeronave retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Long id = new Long(value);
            retorno = aeronaves.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
        	Aeronave aeronave = (Aeronave) value;
            return aeronave.getId() == null ? null : aeronave.getId().toString();
        }

        return "";
    }

}
