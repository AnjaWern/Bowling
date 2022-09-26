import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BowlingTest {

    @Test
    public void frameworkTest() {
        assertTrue(true);
    }

    @Test
    public void cardWithAllFramesZeroResults0() {
        String input = "--|--|--|--|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = new FrameCalculator();
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(0, bowling.calculate(input));
    }

    @Test
    public void cardWithAllFramesZeroExceptFirst1Results1() {
        String input = "1-|--|--|--|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("1-")).thenReturn(1);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(1, bowling.calculate(input));
        verify(frameCalculator, times(1)).calculate("1-");
    }

    @Test
    public void cardWithAllFramesZeroExceptFirst1SecondResults2() {
        String input = "1-|2-|--|--|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("1-")).thenReturn(1);
        when(frameCalculator.calculate("2-")).thenReturn(2);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(3, bowling.calculate(input));
        verify(frameCalculator, times(1)).calculate("1-");
    }

    @Test
    public void cardWithAllFramesZeroExceptFirstSpareSecond2Results14() {
        String input = "1/|2-|--|--|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("1/")).thenReturn(10);
        when(frameCalculator.calculate("2-")).thenReturn(2);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(14, bowling.calculate(input));
    }

    @Test
    public void cardWithAllFramesZeroExceptFirstStrikeSecond4Results18() {
        String input = "X|22|--|--|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("X")).thenReturn(10);
        when(frameCalculator.calculate("22")).thenReturn(4);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(18, bowling.calculate(input));
    }

    @Test
    public void cardWithAllFramesZeroExceptFirstStrikeSecondStrikeThird4Results() {
        String input = "X|X|22|--|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("X")).thenReturn(10);
        when(frameCalculator.calculate("22")).thenReturn(4);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(40, bowling.calculate(input));
    }

    @Test
    public void cardWithAllFramesZeroExceptFirstSpareSecondStrikeThird4Results38() {
        String input = "1/|X|22|--|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("1/")).thenReturn(10);
        when(frameCalculator.calculate("X")).thenReturn(10);
        when(frameCalculator.calculate("22")).thenReturn(4);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(38, bowling.calculate(input));
    }

    @Test
    public void cardWithAllFramesZeroExceptFirst4SecondStrikeThirdSpareFourth4Results40() {
        String input = "22|X|1/|22|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("1/")).thenReturn(10);
        when(frameCalculator.calculate("X")).thenReturn(10);
        when(frameCalculator.calculate("22")).thenReturn(4);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(40, bowling.calculate(input));
    }

    @Test
    public void cardWithAllFramesZeroExceptFirst4SecondSpareThirdStrikeFourth4Results40() {
        String input = "22|1/|X|22|--|--|--|--|--|--||";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("1/")).thenReturn(10);
        when(frameCalculator.calculate("X")).thenReturn(10);
        when(frameCalculator.calculate("22")).thenReturn(4);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(42, bowling.calculate(input));
    }

    @Test
    public void cardWithLastFrameStrikeBonus22Results14() {
        String input = "--|--|--|--|--|--|--|--|--|X||22";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("X")).thenReturn(10);
        when(frameCalculator.calculate("22")).thenReturn(4);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(14, bowling.calculate(input));
    }

    @Test
    public void cardWithLastFrameSpareBonus5Results15() {
        String input = "--|--|--|--|--|--|--|--|--|3/||5";
        FrameCalculator frameCalculator = mock(FrameCalculator.class);
        when(frameCalculator.calculate("3/")).thenReturn(10);
        when(frameCalculator.calculate("5")).thenReturn(5);
        Bowling bowling = new Bowling(frameCalculator);
        assertEquals(15, bowling.calculate(input));
    }

}
