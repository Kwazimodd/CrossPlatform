package edu.crossplatforms.App;

import edu.crossplatforms.l1.utils.NumberUtil;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Enter N - amount of numbers which sum to count:");
                int count = console.nextInt();
                System.out.println("Harmonic sum is: " + NumberUtil.getHarmonicSum(count));
            }
            catch (Exception e) {
                System.out.print("Error occured: " + e.getMessage());
                return;
            }
        }
    }
}
