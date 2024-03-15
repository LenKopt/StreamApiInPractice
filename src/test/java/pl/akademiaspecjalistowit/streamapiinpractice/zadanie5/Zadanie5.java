package pl.akademiaspecjalistowit.streamapiinpractice.zadanie5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Zadanie5 {

    /**
     * ZACZNIJ OD NAPISANIA ASERCJI!
     * <p>
     * Masz listę produktów, gdzie każdy produkt zawiera nazwę, cenę oraz kategorię
     * (np. "Elektronika", "Dom", "Ogród").
     * <p>
     * Twoim zadaniem jest wyfiltrowanie wszystkich produktów
     * o cenie wyższej niż określona wartość, na przykład 100 jednostek pieniężnych,
     * przekształcenie ich nazw na wielkie litery oraz pogrupowanie nazw tych produktów według kategorii.
     */

    @Test
    void zadanie5() {
        //given
        List<Product> products = List.of(
                new Product("Telefon", 250.0, "Elektronika"),
                new Product("Laptop", 1200.0, "Elektronika"),
                new Product("Kosiarka", 150.0, "Ogród"),
                new Product("Biurko", 85.0, "Dom"),
                new Product("Ładowarka", 25.0, "Elektronika"),
                new Product("Grill", 300.0, "Ogród"),
                new Product("Lampa", 50.0, "Dom"),
                new Product("Zestaw narzędzi", 200.0, "Ogród"),
                new Product("Fotel", 400.0, "Dom"),
                new Product("Kamera", 150.0, "Elektronika")
        );
        //when
        Map<String, List<String>> productsGroupedByCategory = findProductsMoreExpensiveThan(products, 100);
        //then
        assertThat(productsGroupedByCategory.size()).isEqualTo(3);
        assertThat(productsGroupedByCategory.get("Elektronika").size()).isEqualTo(3);
        assertThat(productsGroupedByCategory.get("Ogród").size()).isEqualTo(3);
        assertThat(productsGroupedByCategory.get("Dom").size()).isEqualTo(1);
        assertThat(productsGroupedByCategory.get("Dom").get(0)).isEqualTo(productsGroupedByCategory.get("Dom").get(0).toUpperCase());
    }

    private Map<String, List<String>> findProductsMoreExpensiveThan(List<Product> products, int price) {
        return products.
                stream().
                filter(p -> p.getPrice() > price).
                collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(d -> d.getName().toUpperCase(), Collectors.toList())));
    }
}
