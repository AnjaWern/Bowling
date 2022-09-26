import java.util.regex.Pattern;

public class Bowling {
    private FrameCalculator frameCalculator;

    public Bowling(FrameCalculator frameCalculator) {
        this.frameCalculator = frameCalculator;
    }

    public int calculate(String input) {
        String[] splitInput = input.split(Pattern.quote("|"));
        int total = 0;
        boolean lastWasSpare = false;
        boolean lastWasStrike = false;
        boolean lastTwoWereStrikes = false;
        boolean bonus = false;

        for (String frame : splitInput) {

            if ("".equals(frame)) {
                bonus = true;
            } else {
                if (lastWasSpare == true) {
                    total += frameCalculator.firstOfFrameToInt(frame);
                    lastWasSpare = false;
                }

                if (lastTwoWereStrikes == true) {
                    total += frameCalculator.firstOfFrameToInt(frame);
                    lastTwoWereStrikes = false;
                }

                if (lastWasStrike == true) {

                    if ("X".equals(frame)) {
                        lastTwoWereStrikes = true;
                        total += 10;
                        lastWasStrike = false;
                    } else if (frame.endsWith("/")) {
                        total += 10;
                        lastWasStrike = false;
                    } else {
                        total += frameCalculator.firstOfFrameToInt(frame);
                        total += Integer.parseInt(frame.substring(1));
                        lastWasStrike = false;
                    }

                }

            }

            if (!bonus) {
                total += frameCalculator.calculate(frame);

                if (frame.endsWith("/")) {
                    lastWasSpare = true;
                }

                if ("X".equals(frame)) {
                    lastWasStrike = true;
                }
            }
        }
        return total;
    }
}
