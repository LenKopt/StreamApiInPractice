package pl.akademiaspecjalistowit.streamapiinpractice.zadanie4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * ZACZNIJ OD NAPISANIA ASERCJI!
 * <p>
 * Mając listę zamówień, znajdź najczęściej występującą nazwę produktu
 */
public class Zadanie4_1 {

    @Test
    void test() {
        //given
        List<Order> orders = List.of(
                new Order(List.of(new Product("Książka", 30.0), new Product("Długopis", 5.0)), "NOWE"),
                new Order(List.of(new Product("Laptop", 2000.0), new Product("Myszka", 100.0)), "WYSŁANE"),
                new Order(List.of(new Product("Telefon", 500.0), new Product("Etui", 50.0)), "NOWE"),
                new Order(List.of(new Product("Etui", 1838.33), new Product("Myszka", 774.17)), "WYSŁANE"),
                new Order(List.of(new Product("Telefon", 547.42), new Product("Kurtka", 375.12)), "WYSŁANE"),
                new Order(List.of(new Product("Kurtka", 1321.38)), "NOWE"),
                new Order(List.of(new Product("Buty", 1709.76)), "NOWE"),
                new Order(List.of(new Product("Długopis", 1015.35)), "DOSTARCZONE"),
                new Order(
                        List.of(new Product("Buty", 308.45), new Product("Książka", 1899.55), new Product("Telefon", 1885.82)),
                        "WYSŁANE"),
                new Order(List.of(new Product("Etui", 344.15), new Product("Buty", 961.36)), "DOSTARCZONE")
        );
        //when
        List<String> listProductsMostOftenToSale = findProductsMostOftenToSale(orders);
        //then
        assertThat(listProductsMostOftenToSale.size()).isEqualTo(3);
        assertThat(listProductsMostOftenToSale).containsExactlyInAnyOrder("Telefon", "Buty", "Etui");
    }

    private List<String> findProductsMostOftenToSale(List<Order> orders) {
        Map<String, Long> mapNameAndCount = getMapNameAndCount(orders);
        return mapNameAndCount
                .entrySet()
                .stream()
                .filter(e -> e.getValue().equals(getMaxValue(mapNameAndCount)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Map<String, Long> getMapNameAndCount(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts()
                        .stream())
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
    }

    private Long getMaxValue(Map<String, Long> mapNameAndCount) {
        return mapNameAndCount
                .values()
                .stream().max(Long::compareTo)
                .orElse(0L);
    }
}
