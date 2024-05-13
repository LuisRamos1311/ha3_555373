package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.*;
import htw.berlin.wi.prog2.domain.PrecomputedBurger;
import htw.berlin.wi.prog2.domain.Burger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BurgerBuilder {

    private List<Ingredient> ingredients = new ArrayList<>();

    public enum CreationStyle {
        PRECOMPUTED,
        DYNAMICALLY_COMPUTED
    }

    private CreationStyle creationStyle;

    public void setCreationStyle(CreationStyle creationStyle) {
        this.creationStyle = creationStyle;
    }

    public BurgerBuilder add(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public Burger build() {
        if(ingredients.size() < 2) throw new IllegalBurgerException("Nicht genügend Zutaten");
        return creationStyle == CreationStyle.PRECOMPUTED ? buildPrecomputed() : buildDynamicallyComputed();
    }

    private Burger buildPrecomputed() {
        BigDecimal price = BigDecimal.ZERO;
        int calories = 0;
        List<String> ingredientNames = new ArrayList<>();

        for (Ingredient ing : ingredients) {
            price = price.add(ing.getPrice());
            calories += ing.getCalories();
            ingredientNames.add(ing.getName());
        }
        ingredients.clear();

        return new PrecomputedBurger(price, calories, ingredientNames);
    }

    private Burger buildDynamicallyComputed() {
        List<Ingredient> ingsToPass = List.copyOf(ingredients);
        ingredients.clear();
        return new DynamicallyComputedBurger(ingsToPass);
    }

    public BurgerBuilder(CreationStyle creationStyle) {
        this.creationStyle = creationStyle;
    }

    public BurgerBuilder() {
        this(CreationStyle.PRECOMPUTED);
    }
}
