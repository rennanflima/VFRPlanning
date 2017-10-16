/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.converter;

import br.rennan.goldplanning.model.Aerodromo;
import br.rennan.goldplanning.repository.Aerodromos;
import br.rennan.goldplanning.util.cdi.CDIServiceLocator;
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
@FacesConverter(forClass = Aerodromo.class)
public class AerodromoConverter implements Converter {

    @Inject
    private Aerodromos aerodromos;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Aerodromo retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Long id = new Long(value);
            retorno = aerodromos.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Aerodromo aerodromo = (Aerodromo) value;
            return aerodromo.getId() == null ? null : aerodromo.getId().toString();
        }

        return "";
    }

}
