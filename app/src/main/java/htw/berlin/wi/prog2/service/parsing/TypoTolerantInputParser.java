package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class TypoTolerantInputParser implements ExtendableInputParser {

    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {

        Map<Long, Integer> map = new HashMap<>();

        String[] wordList = inputLine.split(" ");

        for(Map.Entry<String, Long> keywordToIdEntry : keywordsToIds.entrySet()) {
            for(String word : wordList) {
                word = word.replace(",","" );
                word = word.replace(".","" );

                if(word.equals("Ciabbata") || word.equals("Ciabata")){
                    word = "Ciabatta";
                }
                if(word.equals("Chedda-Käse") || word.equals("Cheddar-Kaese") || word.equals("Cheddarkäse")){
                    word = "Cheddar-Käse";
                }
                if(word.equals("Rindfleish") || word.equals("RIndfleisch")){
                    word = "Rindfleisch";
                }

                if(keywordToIdEntry.getKey().equals(word)) {
                    if(map.containsKey(keywordToIdEntry.getValue())) {
                        map.put(keywordToIdEntry.getValue(), map.get(keywordToIdEntry.getValue()) + 1);
                    }
                    else {
                        map.put(keywordToIdEntry.getValue(), 1);}
                }
            }
        }

        return map; // TODO hier implementieren und die korrekte Map zurückgeben
    }
}
