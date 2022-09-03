package testsanimal;

import com.example.Animal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class TestAnimalParameterized {

    private final String checkedAnimalKind;
    private final List<String> expectedListFood;

    public TestAnimalParameterized(String checkedAnimalKind, List<String> expectedListFood) {
        this.checkedAnimalKind = checkedAnimalKind;
        this.expectedListFood = expectedListFood;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Всеядные", List.of("Животные", "Птицы", "Рыба", "Трава")},
                {"", List.of("")}
        };
    }

    @Test
    public void TestMethodGetFoodParameterized() throws Exception {
        Animal animal = new Animal();
        if (checkedAnimalKind.equals("Хищник") || checkedAnimalKind.equals("Травоядное")) {
            assertEquals(expectedListFood, animal.getFood(checkedAnimalKind));
        } else {
            try {
                animal.getFood(checkedAnimalKind);
            } catch (Exception exception) {
                throw new Exception(exception);
            }
        }
    }
}
