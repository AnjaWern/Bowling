import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class FrameCalculatorTest {

    @Test
    public void frameResults0() {

        String input = "--";
        int expected = 0;
        FrameCalculator frameCalculator = new FrameCalculator();
        int acutal = frameCalculator.calculate(input);
        assertEquals(expected, acutal);
    }
@Test
    public void frame22Results4() {

        String input = "22";
        int expected = 4;
        FrameCalculator frameCalculator = new FrameCalculator();
        int acutal = frameCalculator.calculate(input);
        assertEquals(expected, acutal);
    }

}
