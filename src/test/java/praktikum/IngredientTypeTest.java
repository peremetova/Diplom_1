package praktikum;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class IngredientTypeTest extends TestCase {

    public void testValues() {
        IngredientType[] expected = {IngredientType.SAUCE, IngredientType.FILLING};
        IngredientType[] actual = IngredientType.values();
        assertArrayEquals("Типы ингридиентов не соответствуют SAUCE, FILLING", expected, actual);
    }

    public void testValueOf() {
        IngredientType actual = IngredientType.valueOf("SAUCE");
        assertEquals("Тип ингридиента SAUCE не существует", IngredientType.SAUCE, actual);
    }
}