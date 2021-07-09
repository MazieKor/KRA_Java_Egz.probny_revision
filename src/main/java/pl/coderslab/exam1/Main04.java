package pl.coderslab.exam1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main04 {
//2 Solutions
    public static void main(String[] args) {
        int[] tab = returnTab2();
        System.out.println("Tablica: " + Arrays.toString(tab));
    }

    public static int[] returnTab() {
        System.out.println("podaj wielkość tabeli: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Nieprawidłowa dana. Podaj jeszcze raz liczbę");
            scan.next();
        }
        int input = scan.nextInt();
        int[] tab = new int[input];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = i + 1;
        }
        return tab;
    }

//2nd Solution:
    public static int[] returnTab2() {
        System.out.println("podaj wielkość tabeli: ");
        Scanner scan = new Scanner(System.in);
        int tableSize;
        while (true) {
            String inputStr = scan.nextLine().trim();
            if (inputStr.contains(" ") || inputStr.contains("\t")) {
                System.out.println("Podaj tylko jedną liczbę. Podaj jeszcze raz");
                continue;
            }
            try {
                tableSize = Integer.parseInt(inputStr);
            } catch (NumberFormatException e) {
                System.out.println("podany znak nie jest liczbą. Podaj liczbę");
                continue;
            }
            break;
        }
        int[] tab = new int[tableSize];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = i + 1;
        }
        return tab;

    }
}