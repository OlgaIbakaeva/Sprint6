import com.example.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class TestsExceptions {

    @Mock
    Feline feline;

    @Test
    public void testAnimalMethodGetFoodException() throws Exception {

        Exception exception = assertThrows(Exception.class, () -> {
            Animal animal = new Animal();
            animal.getFood("");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void testLionConstructionException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
    }

    @Test
    public void testCatMethodGetFoodException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Cat cat = new Cat(feline);
            Mockito.when(feline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            cat.getFood();
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}
