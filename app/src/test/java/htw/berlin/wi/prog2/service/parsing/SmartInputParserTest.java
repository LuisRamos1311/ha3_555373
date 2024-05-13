package htw.berlin.wi.prog2.service.parsing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartInputParserTest {

    private final SmartInputParser sut = new SmartInputParser();

    @Test
    @DisplayName("can understand 'doppelt', 'dreifach', etc.")
    @Disabled // TODO gerne den Test wieder anschalten, falls Sie den SmartInputParser implementiert haben
    void idsAndCountFromInput() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne einen Vollkorn Burger mit Cheddar-Käse und doppelt Rindfleisch.";
        Map<String, Long> keywordsToIds = Map.of(
                "Vollkorn", 19L,
                "Cheddar-Käse", 87L,
                "Rindfleisch", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 1,
                77L, 2);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }
}
