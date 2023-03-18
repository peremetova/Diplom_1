package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends TestCase {
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;
    @Mock
    Bun bun;

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Установленный объект не соответствует ожидаемому", bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue("Ингридиент не добавлен в список", burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Ингридиент не уделен из списка", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(1, 0);
        assertEquals("Ингридиенты не поменялись местами", ingredientSecond, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(20f);
        float actual = burger.getPrice();
        float expected = 40f;
        assertEquals("Цена бургера не соответствует ожидаемой", expected, actual);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(bun.getName()).thenReturn("Французская");
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getName()).thenReturn("Кепчук");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(20f);
        Mockito.when(ingredientSecond.getName()).thenReturn("Сосисон");
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.FILLING);
        String expected = "(==== Французская ====)\n" +
                "= sauce Кепчук =\n" +
                "= filling Сосисон =\n" +
                "(==== Французская ====)\n" +
                "\n" +
                "Price: 40,000000\n";
        String actual = burger.getReceipt();
        assertEquals("Рецепт не соответствует заданному", expected, actual);
    }
}