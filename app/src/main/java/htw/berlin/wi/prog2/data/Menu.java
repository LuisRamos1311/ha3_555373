package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.math.BigDecimal;
import java.util.*;

// Eine statische Datenbank-Klasse
public class Menu {
    private Menu() {}

    public static Map<Long, Ingredient> base = Map.of(
            1L, new Ingredient("Vollkorn", new BigDecimal("0.6"), 120),
            2L, new Ingredient("Ciabatta", new BigDecimal("0.7"), 100));
    public static Map<Long, Ingredient> protein = Map.of(
            3L, new Ingredient("Rindfleisch", new BigDecimal("0.9"), 90),
            4L, new Ingredient("Beyond-Meat", new BigDecimal("0.9"), 80));
    public static Map<Long, Ingredient> topping = Map.of(
            5L, new Ingredient("Tomatenscheiben", new BigDecimal("0.4"), 20),
            6L, new Ingredient("Gurken", new BigDecimal("0.6"), 30),
            7L, new Ingredient("Cheddar-Käse", new BigDecimal("0.6"), 40),
            8L, new Ingredient("Eisbergsalat", new BigDecimal("0.3"), 20));
    public static Map<Long, Ingredient> sauces = Map.of(
            9L, new Ingredient("Mayo", new BigDecimal("0.3"), 40),
            10L, new Ingredient("Ketchup", new BigDecimal("0.3"), 40));

    public static Map<Long, Ingredient> getAllArticles() {
        Map<Long, Ingredient> articles = new HashMap<>();
        articles.putAll(base);
        articles.putAll(protein);
        articles.putAll(topping);
        articles.putAll(sauces);
        return articles;
    }


}
