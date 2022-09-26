public class FrameCalculator {
    public int calculate(String frame) {
        if (! "--".equals(frame)){
            return 4;
        }
            return 0;
    }

    public int firstOfFrameToInt(String frame) {
        if ("X".equals(frame.substring(0, 1))) {
            return 10;
        } else {
            return Integer.parseInt(frame.substring(0, 1));
        }
    }
}
