import com.example.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestsExceptions {

    @Mock
    Feline feline;

    @Test
    public void testAnimalMethodGetFoodException() throws Exception {
        try {
            Animal animal = new Animal();
            animal.getFood("");
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }

    @Test
    public void testLionConstructionException() throws Exception {
        try {
            Lion lion = new Lion("", feline);
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
        }
    }

    @Test
    public void testCatMethodGetFoodException() throws Exception {
        try {
            Cat cat = new Cat(feline);
            Mockito.when(feline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            cat.getFood();
        }
        catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }
}
