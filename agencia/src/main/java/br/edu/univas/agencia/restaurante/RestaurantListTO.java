package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.model.Restaurante;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestaurantListTO {

    private List<Restaurante> restaurantList = new ArrayList<Restaurante>();

    public RestaurantListTO() {
    }

    public List<Restaurante> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurante> cityList) {
        this.restaurantList = cityList;
    }

}
