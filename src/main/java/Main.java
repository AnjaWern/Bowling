import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FrameCalculator frameCalculator = new FrameCalculator();
        Bowling bowling = new Bowling(frameCalculator);
        System.out.println("Enter Bowling Card: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Your points: " + bowling.calculate(input));
    }
}
