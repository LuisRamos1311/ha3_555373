package htw.berlin.wi.prog2.ui;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.data.MenuUtils;
import htw.berlin.wi.prog2.domain.Burger;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.service.parsing.ExtendableInputParser;
import htw.berlin.wi.prog2.service.BurgerBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class CommandLineUI {
    private final UserInputWrapper input;
    private final BurgerBuilder builder;
    private final ExtendableInputParser parser;

    public CommandLineUI(UserInputWrapper uiw, BurgerBuilder sb, ExtendableInputParser ip) {
        input = uiw;
        builder = sb;
        parser = ip;
    }

    public String launch() {
        String inputLine = input.ask("Willkommen beim Burger-Bot! Was möchtest du gerne bestellen?");
        Map<Long, Ingredient> articles = Menu.getAllArticles();
        while (!(inputLine.equals("Bestellung abschliessen") || inputLine.equals("Auf Wiedersehen"))) {
            Map<String, Long> keywordsToIds = MenuUtils.focusOnNameAndInvert(articles);
            Map<Long, Integer> ingredientsCount = parser.idsAndCountFromInput(inputLine, keywordsToIds);
            List<Ingredient> ingredients = MenuUtils.ingredientsFromIdAndCount(ingredientsCount, articles);
            if(ingredients.isEmpty()) {
                inputLine = input.ask("Entschuldigung, ich habe dich nicht verstanden. Wähle aus folgenden Zutaten: "
                        + MenuUtils.focusOnNames(articles));
            } else {
                for (Ingredient ing : ingredients) builder.add(ing);
                Burger burger = builder.build();
                List<String> ingrNames = burger.getIngredientNames().stream().sorted().collect(Collectors.toList());
                inputLine = input.ask("In Ordnung. Dein Burger mit " + ingrNames +
                        " kostet " + burger.calculatePrice() + " Euro. Willst du die Bestellung abschliessen?");
            }
        }
        return inputLine;
    }

}
