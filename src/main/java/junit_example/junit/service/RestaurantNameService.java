package junit_example.junit.service;

import junit_example.junit.model.Restaurant;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class RestaurantNameService {

    public String getReverseName(Restaurant restaurant) {
        return new StringBuffer(restaurant.getName()).reverse().toString();
    }

    public String getFormattedAdress(Restaurant restaurant) {
        return MessageFormat.format(
                "{0} - {1}, {2}",
                restaurant.getName(),
                restaurant.getStreet(),
                restaurant.getCity()
        );

    }
}