package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.*;

public class MenuUtils {

    public static List<String> focusOnNames(Map<Long, Ingredient> articles) {
        List<String> names = new ArrayList<>();
        for (Ingredient art : articles.values()) {
            names.add(art.getName());
        }
        return names;
    }

    //For-Loop, New HashMap with Output: Name, Key
    public static Map<String, Long> focusOnNameAndInvert(Map<Long, Ingredient> articles) {
        Map<String, Long> map = new HashMap<>();

        for(Map.Entry<Long,Ingredient> art : articles.entrySet()) {
           
            map.put(art.getValue().getName(), art.getKey());
        }
        return map; // TODO hier implementieren und korrekte Ergebnis-Map zurückgeben
    }

    //New ArrayList
    //For-Loop to count the ingredients
    public static List<Ingredient> ingredientsFromIdAndCount(Map<Long, Integer> idsAndCount, Map<Long, Ingredient> articles) {

        List<Ingredient> ingredientList = new ArrayList<>();

        for(Map.Entry<Long,Integer> idAndCount : idsAndCount.entrySet()) {
            for(int i=0; i < idAndCount.getValue(); i++){
                ingredientList.add(articles.get(idAndCount.getKey()));
            }
        }
        return ingredientList; // TODO hier implementieren und korrekte Ergebnis-Liste zurückgeben
    }
}
