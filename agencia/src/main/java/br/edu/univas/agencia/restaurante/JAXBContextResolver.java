package br.edu.univas.agencia.restaurante;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@SuppressWarnings("rawtypes")
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

    private final JAXBContext context;
    private final Set<Class> types;
    private final Class[] classesToBeBound = {RestaurantListTO.class, CityListTO.class};

    @SuppressWarnings("unchecked")
    public JAXBContextResolver() throws JAXBException {
        this.types = new HashSet(Arrays.asList(classesToBeBound));
        this.context = new JSONJAXBContext(JSONConfiguration.natural().build(), classesToBeBound);
    }

    @Override
    public JAXBContext getContext(Class<?> type) {
        return types.contains(type) ? context : null;
    }

}
