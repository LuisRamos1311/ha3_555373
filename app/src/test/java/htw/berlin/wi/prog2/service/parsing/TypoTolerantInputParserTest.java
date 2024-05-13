package htw.berlin.wi.prog2.service.parsing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypoTolerantInputParserTest {

    private final TypoTolerantInputParser sut = new TypoTolerantInputParser();

    @Test
    @DisplayName("can make use of the provided different spellings or common typos")
    void idsAndCountFromInput() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne einen Ciabata Burger mit Chedda-Käse, Rindfleish und nochmal Rindfleisch";
        Map<String, Long> keywordsToIds = Map.of(
                "Ciabbata", 19L,
                "Ciabatta", 19L,
                "Ciabata", 19L,
                "Cheddar-Käse", 87L,
                "Chedda-Käse", 87L,
                "Cheddar-Kaese", 87L,
                "Cheddarkäse", 87L,
                "Rindfleisch", 77L,
                "Rindfleish", 77L,
                "RIndfleisch", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 1,
                77L, 2);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }
}
