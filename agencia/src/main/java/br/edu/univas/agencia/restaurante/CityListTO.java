package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.model.Cidade;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CityListTO {

    private Collection<Cidade> cityList;

    public CityListTO() {
        cityList = new ArrayList<Cidade>();
    }

    public Collection<Cidade> getCityList() {
        return cityList;
    }

    public void setCityList(Collection<Cidade> cityList) {
        this.cityList = cityList;
    }

}
