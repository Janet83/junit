package junit_example.junit.service;

import junit_example.junit.model.Restaurant;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantNameServiceTest {

    @InjectMocks RestaurantNameService restaurantNameService;

    Restaurant restaurant;

    @BeforeEach
    void setup()    {
        restaurant = new Restaurant(1L, "Nazwa", "Ulica", "Miasto");
    }

/*    @Test
    void getReverseName() {
        //arrange
        //Restaurant restaurant = new Restaurant(1L, "Nazwa", "ulica", "Miasto");
        //act
        String result = restaurantNameService.getReverseName(restaurant);
        //assert
        assertEquals("awzaN", result, "Nazwa restauracji nie została poprawnie wyświetlona");
    }*/

    public static Stream<Arguments> provider()  {
        return Stream.of(
                Arguments.of(new Restaurant(1L, "Moja", "Wiśniowa", "Sopot"), "ajoM"),
                Arguments.of(new Restaurant(1L, "Twoja", "Malinowa", "Gdynia"), "ajowT"),
                Arguments.of(new Restaurant(1L, "Nasza", "Truskawkowa", "Gdańsk"), "azsaN")
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void getReverseName_parametrized(Restaurant restaurant, String expected) {
        //arrange
        //Restaurant restaurant = new Restaurant(1L, "Nazwa", "ulica", "Miasto");

        //act
        String result = restaurantNameService.getReverseName(restaurant);

        //assert
        assertEquals(expected, result, "Nazwa restauracji nie została poprawnie wyświetlona");

    }

    @Test
    void getFormattedAdress() {
        //arramge
        //Restaurant restaurant = new Restaurant(1L, "Nazwa", "Ulica", "Miasto"); usunięto po dodaniu 17-22

        //act
        String result = restaurantNameService.getFormattedAdress(restaurant);

        //assert
        assertEquals("Nazwa - Ulica, Miasto", result);
    }

    @Disabled
    @DisplayName("BARDZO WAŻNY TEST")
    @ParameterizedTest
    @ValueSource(ints ={1, 3, 5, 7})
    void isOdd(int number)  {
        assertEquals(1, number % 2);
    }
}