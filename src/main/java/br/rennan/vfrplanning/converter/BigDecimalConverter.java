package br.rennan.vfrplanning.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("bigDecimalConverter")
public class BigDecimalConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		value = value.replace(".", "");
		value = value.replace(",", ".");
		if (value.contains(".")) {
			String decimalPlace = value.substring(value.indexOf("."));
			if (decimalPlace.length() > 3) {
				throw new ConverterException(new FacesMessage("too many numbers after decimal point"));
			}
		}
		BigDecimal convertedValue = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
		
		return convertedValue;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((BigDecimal) value).toString();
	}

}
