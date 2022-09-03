package testsfeline;

import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class TestsFeline {

    @Test
    public void testMethodGetKittensWithoutParameters() {
        Feline feline = new Feline();
        assertEquals(1,feline.getKittens());
    }

    @Test
    public void testMethodGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testMethodEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
}
