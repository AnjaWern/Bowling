public class FrameCalculator {
    public int calculate(String frame) {

        if (isMiss(frame)) {
            return 0;
        }

        if (isSpare(frame) || isStrike(frame)) {
            return 10;
        }

        int result = firstOfFrameToInt(frame) + secondOfFrameToInt(frame);
        return result;
    }

    public int firstOfFrameToInt(String frame) {
        if (isStrike(frame)) {
            return 10;
        } else {
            return Integer.parseInt(frame.substring(0, 1));
        }
    }

    private int secondOfFrameToInt(String frame) {
        return Integer.parseInt(frame.substring(1));
    }

    private boolean isStrike(String frame) {
        return "X".equals(frame.substring(0, 1));
    }

    private boolean isSpare(String frame) {
        return "/".equals(frame.substring(1));
    }

    private boolean isMiss(String frame) {
        return "--".equals(frame);
    }
}
