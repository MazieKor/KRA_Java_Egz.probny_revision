package pl.coderslab.exam1;

import java.util.Arrays;
import java.util.Random;

public class Main03 {
    public static void main(String[] args) {
        int size = 5;
        int interval = 26;
        System.out.println("uzyskana tablica to: " + Arrays.toString(div(size,interval)));

    }
    public static int[] div(int size, int interval){
        Random rand = new Random();
        int[] tab = new int[size];
        for (int i = 0; i < tab.length; i++) {
            boolean value = true;
            while(value){
                int number = rand.nextInt(interval)+1;
                if( number % 2 == 0 && number % 3 != 0){
                    value = false;
                    tab[i] = number;
                }
             }
        }
        return tab;
    }


}
