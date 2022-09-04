package testslion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLionParameterized {
    private final String checkedSex;
    private final boolean expectedIs;

    public TestLionParameterized(String checkedSex, boolean expectedIs) {
        this.checkedSex = checkedSex;
        this.expectedIs = expectedIs;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public  void TestMethodDoesHaveManeParameterized() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(checkedSex, feline);
        assertEquals(expectedIs, lion.doesHaveMane());
    }
}
