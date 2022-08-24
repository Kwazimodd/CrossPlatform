import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Enter N - amount of numbers which sum to count:");
                int count = console.nextInt();
                System.out.println();
                System.out.println("Harmonic sum is: " + SumUtil.getHarmonicSum(count));
            }
            catch (Exception e) {
                System.out.print("Error occured: " + e.getMessage());
                return;
            }
        }
    }
}
