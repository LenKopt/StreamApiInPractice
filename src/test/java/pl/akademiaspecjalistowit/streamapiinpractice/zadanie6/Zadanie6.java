package pl.akademiaspecjalistowit.streamapiinpractice.zadanie6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Zadanie6 {

    // Zadanie 1: Oblicz średnią arytmetyczną liczb całkowitych z danej listy.
    @Test
    public void testCalculateAverage() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        double result = calculateAverage(numbers);

        // then
        assertEquals(3.0, result, 0.0001);
    }

    private double calculateAverage(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(number -> number)
                .average()
                .orElse(0);
    }

    // Zadanie 2: Wybierz wszystkie liczby parzyste z danej listy.
    @Test
    public void testFilterEvenNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when
        List<Integer> result = filterEvenNumbers(numbers);

        // then
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), result);
    }

    private List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

    // Zadanie 3: Oblicz sumę kwadratów liczb z danej listy.
    @Test
    public void testCalculateSumOfSquares() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        int result = calculateSumOfSquares(numbers);

        // then
        assertEquals(55, result);
    }

    private int calculateSumOfSquares(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(number -> number * number)
                .sum();
    }

    // Zadanie 4: Połącz wszystkie napisy z danej listy w jeden.
    @Test
    public void testConcatenateStrings() {
        // given
        List<String> strings = Arrays.asList("Hello", " ", "world", "!");

        // when
        String result = concatenateStrings(strings);

        // then
        assertEquals("Hello world!", result);
    }

    private String concatenateStrings(List<String> strings) {
        return strings
                .stream()
                .collect(Collectors.joining());
    }

    // Zadanie 5: Znajdź najdłuższy napis w danej liście.
    @Test
    public void testFindLongestString() {
        // given
        List<String> strings = Arrays.asList("apple", "banana", "orange", "kiwi");

        // when
        String result = findLongestString(strings);

        // then
        assertEquals("banana", result);
    }

    private String findLongestString(List<String> strings) {
        List<Integer> listLengths = strings
                .stream()
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .toList();
        return strings
                .stream()
                .filter(word -> word.length() == listLengths.getFirst())
                .findFirst().orElse("");
    }


    // Zadanie 6: Zlicz ilość wystąpień każdego słowa w danym tekście.
    @Test
    public void testCountWordOccurrences() {
        // given
        Map<String, Long> expected = new HashMap<>();
        expected.put("Lorem", 1L);
        expected.put("ipsum", 1L);
        expected.put("dolor", 1L);
        expected.put("sit", 1L);
        expected.put("amet", 1L);
        expected.put("consectetur", 1L);
        expected.put("adipiscing", 1L);
        expected.put("elit", 1L);
        String text = "Lorem ipsum dolor sit amet consectetur adipiscing elit";

        // when
        Map<String, Long> result = countWordOccurrences(text);

        // then
        assertEquals(expected, result);
    }

    private Map<String, Long> countWordOccurrences(String text) {
        return Arrays
                .stream(text.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    // Zadanie 7: Znajdź wszystkie unikalne elementy w danej liście.
    @Test
    public void testFindUniqueElements() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        // when
        Set<Integer> result = findUniqueElements(numbers);

        // then
        assertEquals(expected, result);
    }

    private Set<Integer> findUniqueElements(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(number -> numbers.contains(number))
                .collect(Collectors.toSet());
    }


    // Zadanie 8: Oblicz sumę wszystkich elementów z danej listy większych od określonej wartości.
    @Test
    public void testCalculateSumOfElementsGreaterThanValue() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when
        int result = calculateSumOfElementsGreaterThanValue(numbers, 5);

        // then
        assertEquals(45, result);
    }

    private int calculateSumOfElementsGreaterThanValue(List<Integer> numbers, int i) {
        return numbers
                .stream()
                .filter(number -> number >= i)
                .reduce((a, b) -> a + b)
                .orElse(0);
    }

    // Zadanie 9: Oblicz średnią długość słów w danej liście napisów.
    @Test
    public void testCalculateAverageWordLength() {
        // given
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi");

        // when
        int result = calculateAverageWordLength(words);

        // then
        assertEquals(5.0, result, 0.0001);
    }

    private int calculateAverageWordLength(List<String> words) {
        return (int) words
                .stream()
                .mapToInt(word -> word.length())
                .average()
                .orElseThrow();
    }

    // Zadanie 10: Sprawdź, czy wszystkie liczby w danej liście są dodatnie.
    @Test
    public void testAreAllNumbersPositive() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        boolean result = areAllNumbersPositive(numbers);

        // then
        assertTrue(result);
    }

    private boolean areAllNumbersPositive(List<Integer> numbers) {
        return false;
    }

    // Zadanie 11: Znajdź najmniejszą liczbę w danej liście.
    @Test
    public void testFindMinimumNumber() {
        // given
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9);

        // when
        int result = findMinimumNumber(numbers);

        // then
        assertEquals(1, result);
    }

    private int findMinimumNumber(List<Integer> numbers) {
        return 0;
    }

    // Zadanie 12: Znajdź ostatnią literę każdego słowa w danej liście napisów.
    @Test
    public void testFindLastLetterOfEachWord() {
        // given
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi");

        // when
        List<Character> result = findLastLetterOfEachWord(words);

        // then
        assertEquals(Arrays.asList('e', 'a', 'e', 'i'), result);
    }

    private List<Character> findLastLetterOfEachWord(List<String> words) {
        return null;
    }
}