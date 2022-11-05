package junit_example.junit.repository;

import junit_example.junit.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RestaurantRepository {

    private static List<Restaurant> restaurants = new LinkedList<>() {{
        add(new Restaurant(1L, "Pierogarnia", "Długa 7", "Gdańsk"));
        add(new Restaurant(1L, "Pizzeria", "Szeroka 3", "Gdańsk"));
        add(new Restaurant(1L, "McDonalds", "Krótka 9", "Gdynia"));
    }};

    public Optional<Restaurant> get(Long id) {
        return restaurants
            .stream()
            .filter(r -> Objects.equals(r.getId(), id))
                .findFirst();
    }
}
