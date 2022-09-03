package testsfeline;

import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestFelineParameterized {

    private final int checkedNumber;
    private final int expectedNumber;

    public TestFelineParameterized(int checkedNumber, int expectedNumber) {
        this.checkedNumber = checkedNumber;
        this.expectedNumber = expectedNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {5, 5},
                {0, 0},
                {100, 100},
                {-1, -1},
                {-100, -100}
        };
    }

    @Test
    public void TestMethodGetKittensWithParameterParameterized() {
        Feline feline = new Feline();
        assertEquals(expectedNumber,feline.getKittens(checkedNumber));
    }
}
