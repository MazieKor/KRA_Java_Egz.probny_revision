package pl.coderslab.exam1;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;


import static java.lang.Math.PI;

public class Main05 {
//3 Solutions

    public static void main(String[] args) {
        double volumeOfSphere = Math.round(sphere() * 1000.0) / 1000d;  //NEW: dzielenie przez double'a żeby zadziałao
        System.out.println("Objętość kuli to: " + volumeOfSphere);

        double volumeOfSphere2 = sphere3();
//        Locale.setDefault(Locale.ENGLISH);
        DecimalFormat format = new DecimalFormat("#,###.0000 m3");
        String formattedVolume = format.format(volumeOfSphere2);
        System.out.println("Objętość kuli to: " + formattedVolume);
    }

//1st Solution
    public static double sphere() {
        System.out.println("Podaj promień kuli (wartości dziesiętne podaj z użyciem przecinka): ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextDouble()) {  //NEW jako doublea mogę podać po prostu 8
            System.out.println("podałeś nieprawidłową wartość podaj jeszcze raz");
            scan.next();
        }
        double radius = scan.nextDouble();    //NEW: Mimo że podałem z przecinkiem (nie kropką) mogę przypisać (scanner interpretuje liczbę z przecinkiem jako liczbę więc mogę przypisac doublowi. Liczbę z kropką nie przyjmował w ogóle)
        double radius_3 = Math.pow(radius, 3);
        return 4d / 3d * Math.PI * radius_3;    //NEW: Żeby otrzymać double musze wprowadzić 4/3 w doubleu
    }

//2nd Solution
    public static double sphere2() {
        System.out.println("Podaj promień w celu obliczenia objętości kuli: ");
        Scanner scan = new Scanner(System.in);
        double inputDouble;
        while (true) {
            String inputString = scan.nextLine().trim();
            if (inputString.contains(" ") || inputString.contains("\t")) {
                System.out.println("podałeś więcej niż jeden ciąg znaków. Podaj jeszcze raz liczbę, nie oddzielaj znaków spacjami lub tabulatorami");
                continue;
            }
            try {
                inputDouble = Double.parseDouble(inputString);
            } catch (NumberFormatException e) {
                System.out.println("Wprowadzona ciąg nie jest liczbą. Podaj liczbę (dla wartości dziesiętnych użyj kropki)");
                continue;
            }
            break;
        }
        double radius_3 = Math.pow(inputDouble, 3d);
        return 4d / 3d * PI * radius_3;
    }

//3rd Solution
    public static double sphere3() {
        System.out.println("Podaj promień w celu obliczenia objętości kuli: ");
        Scanner scan = new Scanner(System.in);
        String input;
        while (true) {
            input = scan.nextLine().trim();
            if (input.contains(" ") || input.contains("\t")) {
                System.out.println("podałeś więcej niż jeden ciąg znaków. Podaj jeszcze raz liczbę, nie oddzielaj znaków spacjami lub tabulatorami");
                continue;
            }
            if (!NumberUtils.isParsable(input)) {
                System.out.println("Wprowadzona ciąg nie jest liczbą. Podaj liczbę (dla wartości dziesiętnych użyj kropki)");
                continue;
            }
            break;
        }
            double radius = Double.parseDouble(input);
            double radius_3 = Math.pow(radius, 3.0);
            return (double) 4 / 3 * PI * radius_3;
    }

}