package praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class BunTest extends TestCase {

    private static final String NAME = "name";

    @Test
    public void testGetName() {
        Bun bun = new Bun(NAME, 40f);
        assertEquals("Имя не соответсвует заданному", NAME, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(NAME, 50f);
        assertEquals("Цена не соответствует заданной", 50f, bun.getPrice());
    }
}