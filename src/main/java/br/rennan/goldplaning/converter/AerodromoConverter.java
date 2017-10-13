/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplaning.converter;

import br.rennan.goldplaning.model.Aerodromo;
import br.rennan.goldplaning.repository.Aerodromos;
import br.rennan.goldplaning.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author rennan.lima
 */
@FacesConverter(forClass = Aerodromo.class)
public class AerodromoConverter implements Converter {

    private Aerodromos aerodromos;

    public AerodromoConverter() {
        aerodromos = CDIServiceLocator.getBean(Aerodromos.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Aerodromo retorno = null;

        if (value != null) {
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
