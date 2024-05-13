package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Burger;
import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerBuilderTest {

    private final BurgerBuilder builder  = new BurgerBuilder();

    private final Ingredient sauce = new Ingredient("Mayo", new BigDecimal("0.01"), 2000);
    private final Ingredient teig = new Ingredient("Teig", new BigDecimal("0.02"), 1000);

    @Test
    @DisplayName("can build a precomputed burger with two ingredients")
    void buildABurger() {
        builder.setCreationStyle(BurgerBuilder.CreationStyle.PRECOMPUTED);
        Burger burger = builder.add(teig).add(sauce).build();

        assertEquals(List.of("Teig", "Mayo"), burger.getIngredientNames());
        assertEquals(new BigDecimal("0.03"), burger.calculatePrice());
        assertEquals(3000, burger.calculateCalories());
    }

    @Test
    @DisplayName("can build two precomputed burgers after another without mixing things up")
    void buildTwoBurgers() {
        builder.setCreationStyle(BurgerBuilder.CreationStyle.PRECOMPUTED);
        Burger burger1 = builder.add(teig).add(sauce).build();
        Burger burger2 = builder.add(teig).add(teig).build();

        assertEquals(List.of("Teig", "Mayo"), burger1.getIngredientNames());
        assertEquals(List.of("Teig", "Teig"), burger2.getIngredientNames());
    }

    @Test
    @DisplayName("can build a dynamically computed burger with two ingredients")
    void buildABurgerDynamically() {
        builder.setCreationStyle(BurgerBuilder.CreationStyle.DYNAMICALLY_COMPUTED);
        Burger burger = builder.add(teig).add(sauce).build();

        assertEquals(List.of("Teig", "Mayo"), burger.getIngredientNames());
        assertEquals(new BigDecimal("0.03"), burger.calculatePrice());
        assertEquals(3000, burger.calculateCalories());
    }

    @Test
    @DisplayName("can build two dynamically computed burgers after another without mixing things up")
    void buildTwoBurgersDynamically() {
        builder.setCreationStyle(BurgerBuilder.CreationStyle.DYNAMICALLY_COMPUTED);
        Burger burger1 = builder.add(teig).add(sauce).build();
        Burger burger2 = builder.add(teig).add(teig).build();

        assertEquals(List.of("Teig", "Mayo"), burger1.getIngredientNames());
        assertEquals(List.of("Teig", "Teig"), burger2.getIngredientNames());
    }

    @Test
    @DisplayName("a burger should have at least two ingredients")
    void checkNumberOfIngredients() {
        assertThrows(IllegalBurgerException.class, builder::build);
        assertThrows(IllegalBurgerException.class, () -> builder.add(teig).build());
    }
}
