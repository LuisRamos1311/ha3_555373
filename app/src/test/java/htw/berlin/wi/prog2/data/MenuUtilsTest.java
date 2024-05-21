package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MenuUtilsTest {

    private final Ingredient gurken = new Ingredient("Gurken", new BigDecimal("0.01"), 1000);
    private final Ingredient kaese = new Ingredient("Cheddar-Käse", new BigDecimal("0.02"), 2000);
    private final Ingredient fleisch = new Ingredient("Rindfleisch", new BigDecimal("0.03"), 3000);

    private final Map<Long, Ingredient> testMenu = Map.of(
            42L, gurken,
            66L, kaese,
            17L, fleisch);

    @Test
    @DisplayName("should extract only the ingredient names from the Menu")
    void focusOnNames() {
        List<String> expected = List.of("Gurken", "Cheddar-Käse", "Rindfleisch");
        List<String> actual = MenuUtils.focusOnNames(testMenu);

        List<String> expectedSorted = expected.stream().sorted().collect(Collectors.toList());
        List<String> actualSorted = actual.stream().sorted().collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    @DisplayName("should select the ingredient name and invert the passed map, i.e. keys become values and values become keys")
    void focusOnNameAndInvert() {
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(testMenu);
        Map<String, Long> expected = Map.of(
                "Gurken", 42L,
                "Cheddar-Käse", 66L,
                "Rindfleisch", 17L);
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Input and return an empty Map")
    void emptyMap() {
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(Map.of());
        Map<String, Long> expected = Map.of();
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should get the ingredients from the passed menu in the stated quantities of the input map")
    void ingredientsFromIdAndCount() {
        Map<Long, Integer> counts = Map.of(
                66L, 1,
                17L, 2);

        List<Ingredient> expected = List.of(kaese, fleisch, fleisch);
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(counts, testMenu);

        Comparator<Ingredient> byName = Comparator.comparing(Ingredient::getName);
        List<Ingredient> expectedSorted = expected.stream().sorted(byName).collect(Collectors.toList());
        List<Ingredient> actualSorted = actual.stream().sorted(byName).collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    @DisplayName("Input and return an empty Map")
    void emptyMap2() {
        Map<Long, Integer> counts = Map.of();

        List<Ingredient> expected = List.of();
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(counts, Map.of());

        Comparator<Ingredient> byName = Comparator.comparing(Ingredient::getName);
        List<Ingredient> expectedSorted = expected.stream().sorted(byName).collect(Collectors.toList());
        List<Ingredient> actualSorted = actual.stream().sorted(byName).collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }
}
