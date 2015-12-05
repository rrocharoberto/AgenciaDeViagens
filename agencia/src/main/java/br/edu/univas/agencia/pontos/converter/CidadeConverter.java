package br.edu.univas.agencia.pontos.converter;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.univas.agencia.model.Cidade;

@FacesConverter(value = "cidadeConverter")
public class CidadeConverter implements Converter {
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {		
		if(value != null && !value.isEmpty()){
			return this.getAttributesFrom(component).get(value);
		}else{		
			return null;
		}
	}

	
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
        if (value != null && !"".equals(value)) {  
        	Cidade entity = (Cidade) value;  
  
            this.addAttribute(component, entity);  
  
            Integer codigo = entity.getId();  
            if (codigo != null) {  
                return String.valueOf(codigo);  
            }  
        }  
  
        return (String) value; 		
	}
	
    protected void addAttribute(UIComponent component, Cidade city) {  
        String key = city.getId().toString();  
        this.getAttributesFrom(component).put(key, city);  
    }  
    
    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
        return component.getAttributes();  
    } 
}