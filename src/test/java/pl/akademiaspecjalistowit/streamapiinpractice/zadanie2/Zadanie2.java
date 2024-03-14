package pl.akademiaspecjalistowit.streamapiinpractice.zadanie2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Zadanie2 {

    /**
     * ZACZNIJ OD NAPISANIA ASERCJI!
     * <p>
     * twórz funkcję, która przyjmuje listę słów i zwraca mapę,
     * gdzie kluczem jest długość słowa, a wartością ilość słów o tej długości.
     */
    @Test
    void grouping() {
        //given
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        //when
        Map<Integer, Long> wordCount = groupWords(words);
        //then
        assertThat(wordCount.size()).isEqualTo(4);
        assertThat(wordCount.get(3)).isEqualTo(1);
        assertThat(wordCount.get(4)).isEqualTo(1);
        assertThat(wordCount.get(5)).isEqualTo(2);
        assertThat(wordCount.get(6)).isEqualTo(2);
    }

    private Map<Integer, Long> groupWords(List<String> words) {
        return words.
                stream().
                map(k -> k.length()).
                peek(System.out::println).
                collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    }
}
