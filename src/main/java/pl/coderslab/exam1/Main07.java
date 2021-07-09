package pl.coderslab.exam1;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;

public class Main07 {
//3 Solutions - incl. negatives or not:
    public static void main(String[] args) {
        String str = "-2Wyl3icza4nie su-5my liczb znajdujących sIę w Stringu!-2";
        try {
            int result = countNumbers(str);  //int result = countNumbers3(str);
            if (result < 0)
                System.out.println("W ciągu nie ma żadnych liczb");
            else
                System.out.println("Suma liczb w przesłanym Stringu to: " + result);
        } catch (NullPointerException e) {
            System.out.println("Podany ciąg nie może być nullem");
        }

        try {
            int result = countNumbers2(str);
            System.out.println("Suma liczb w przesłanym Stringu to: " + result);
        } catch (NullPointerException e) {
            System.out.println("Podany ciąg nie może być nullem");
        }
    }

//1st Solution - sums only positives:
    public static int countNumbers(String str) {
        char[] tab = str.toCharArray();
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < tab.length; i++) {
            if (Character.isDigit(tab[i])) {
                sum += Integer.parseInt(String.valueOf(tab[i]));  //NEW nie mogę parsować charów
                counter++;
            }
        }
        if (counter == 0)
            return -1;
        return sum;
    }

//2nd Solution - incl. negatives:
    public static int countNumbers2(String str) {
        char[] tab = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < tab.length; i++) {
            if (Character.isDigit(tab[i]) && i == 0)
                sum += Integer.parseInt(String.valueOf(tab[i]));
            else if (Character.isDigit(tab[i]) && i > 0) {
                if (tab[i - 1] == '-')
                    sum -= Integer.parseInt(String.valueOf(tab[i]));
                else
                    sum += Integer.parseInt(String.valueOf(tab[i]));
            }
        }
        return sum;
    }
/**3rd Solution - with Apache Common Lang, only positives*/
    public static int countNumbers3(String str) {
        String[] tab = str.split("");
        System.out.println("TEST - tablica: " + Arrays.toString(tab));
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < tab.length; i++) {
            if (NumberUtils.isDigits(tab[i])) {
                sum += Integer.parseInt((tab[i]));
                counter++;
            }
        }
        if (counter == 0)
            return -1;
        return sum;
    }
}
