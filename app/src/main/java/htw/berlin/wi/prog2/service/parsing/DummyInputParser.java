package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class DummyInputParser implements ExtendableInputParser {
    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        Map<Long, Integer> idsAndCount = new HashMap<>();
        if(inputLine.contains("Vollkorn")) idsAndCount.put(keywordsToIds.get("Vollkorn"), 1);
        if(inputLine.contains("Rindfleisch")) idsAndCount.put(keywordsToIds.get("Rindfleisch"), 1);
        return idsAndCount;
    }
}
