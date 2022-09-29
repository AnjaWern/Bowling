import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameCalculatorTest {

    @Test
    public void frameResults0() {

        String input = "--";
        int expected = 0;
        FrameCalculator frameCalculator = new FrameCalculator();
        int actual = frameCalculator.calculate(input);
        assertEquals(expected, actual);
    }

    @Test
    public void frame22Results4() {

        String input = "22";
        int expected = 4;
        FrameCalculator frameCalculator = new FrameCalculator();
        int acutal = frameCalculator.calculate(input);
        assertEquals(expected, acutal);
    }

    @Test
    public void frame34Results7() {

        String input = "34";
        int expected = 7;
        FrameCalculator frameCalculator = new FrameCalculator();
        int acutal = frameCalculator.calculate(input);
        assertEquals(expected, acutal);
    }

    @Test
    public void frame3SlashResults10() {

        String input = "3/";
        int expected = 10;
        FrameCalculator frameCalculator = new FrameCalculator();
        int acutal = frameCalculator.calculate(input);
        assertEquals(expected, acutal);
    }

    @Test
    public void frameXResults10() {

        String input = "X";
        int expected = 10;
        FrameCalculator frameCalculator = new FrameCalculator();
        int acutal = frameCalculator.calculate(input);
        assertEquals(expected, acutal);
    }

}
