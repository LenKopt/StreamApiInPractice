package pl.akademiaspecjalistowit.streamapiinpractice.zadanie0;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;

public class Zadanie0 {

    private Person jan;
    private Person ola;
    private Person asia;
    private Person anna;
    private Person przemek;

    private List<Person> people;

    @BeforeEach
    void setUp() {
        jan = new Person("Jan", 17);
        ola = new Person("Ola", 18);
        asia = new Person("Asia", 39);
        anna = new Person("Anna", 23);
        przemek = new Person("Przemek", 23);

        people = List.of(jan, ola, asia, anna, przemek);
    }

    /**
     * Masz listę osób (List<Person>), gdzie Person to klasa zawierająca pola
     * String name i int age. Znajdź wszystkie osoby, które są pełnoletnie.
     */
    @Test
    public void testFindAdults() {
        //given

        //when
        List<Person> adults = findAdults(people);

        //then
        assertThat(adults).hasSize(4);
        assertThat(adults).containsOnly(ola, asia, anna, przemek);
    }

    private List<Person> findAdults(List<Person> people) {
        //todo IMPLEMENT ME
        return people
                .stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());
    }


    /**
     * Oblicz średni wiek osób z listy List<Person>.
     */
    @Test
    public void testAverageAge() {
        //given

        //when
        double avg = calculateAverageAge(people);

        //then
        assertThat(avg).isEqualTo(24.00);
    }

    private double calculateAverageAge(List<Person> people) {
        return people.stream()
                .mapToDouble(Person::age)
                .average()
                .orElse(0);
    }

    /**
     * Zgrupuj osoby z listy List<Person> według wieku w mapie,
     * gdzie klucz to wiek, a wartość to lista osób w tym wieku.
     */
    @Test
    public void testGroupByAge() {
        //given

        //when
        Map<Integer, List<Person>> groupedByAge = groupPeopleByAge(people);

        //then
        assertThat(groupedByAge.size()).isEqualTo(4);
        assertThat(groupedByAge.get(17).size()).isEqualTo(1);
        assertThat(groupedByAge.get(18).size()).isEqualTo(1);
        assertThat(groupedByAge.get(39).size()).isEqualTo(1);
        assertThat(groupedByAge.get(23).size()).isEqualTo(2);
    }

    private Map<Integer, List<Person>> groupPeopleByAge(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::age, Collectors.toList()));
    }


}
