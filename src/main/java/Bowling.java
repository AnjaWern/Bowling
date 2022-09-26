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
                    total += firstOfFrameToInt(frame);
                    lastWasSpare = false;
                }

                if (lastTwoWereStrikes == true) {
                    total += firstOfFrameToInt(frame);
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
                        total += firstOfFrameToInt(frame);
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

    public int firstOfFrameToInt(String frame) {
        if ("X".equals(frame.substring(0, 1))) {
            return 10;
        } else {
            return Integer.parseInt(frame.substring(0, 1));
        }

    }

}
