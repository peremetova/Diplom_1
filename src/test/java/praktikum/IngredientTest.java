package praktikum;


import junit.framework.TestCase;

public class IngredientTest extends TestCase {

    private static final String NAME = "name";
    private static final IngredientType TYPE = IngredientType.SAUCE;

    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, 20f);
        assertEquals("Цeна ингридиента не соответствует ожидаемой", 20f, ingredient.getPrice());
    }

    public void testTestGetName() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, 20f);
        assertEquals("Название ингридиента не соответствует ожидаемому", NAME, ingredient.getName());
    }

    public void testGetType() {
        Ingredient ingredient = new Ingredient(TYPE, NAME, 20f);
        assertEquals("Тип ингридиента не соответствует ожидаемому", TYPE, ingredient.getType());
    }
}