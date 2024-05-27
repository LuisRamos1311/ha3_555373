package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class CountingInputParser implements ExtendableInputParser {

    //New Hash-Map
    //First delete the blank-spaces and create a list of words
    //Delete the commas and points
    //If we find a word on the sentece that is on the map, we add it
    //If the word was already added, we increase the value by +1
    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {

        Map<Long, Integer> map = new HashMap<>();

        String[] wordList = inputLine.split(" ");
        for(Map.Entry<String, Long> keywordToIdEntry : keywordsToIds.entrySet()) {
            for(String word : wordList) {
                word = word.replace(",","" );
                word = word.replace(".","" );

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
