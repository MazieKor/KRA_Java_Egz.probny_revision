package pl.coderslab.exam1;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        create(71);
    }

    public static void create(int max) {
        int maxPointsNumber = max;
        int passingTreshold = (int) (max * 0.6);  //NEW Mnożenie int i double
        Scanner scan = new Scanner(System.in);

        String input = getNumberOfStudents(scan);
        String[] examData = getExamData(maxPointsNumber, scan, input);
        Path path = getPath(scan);
        if (path == null) return;

        List<String> listOfResults = Arrays.asList(examData);
        try {
            Files.write(path, listOfResults);
        } catch (IOException e) {
            System.out.println("Plik exam nie zostal zapisany. Spróbuj od początku");
            return;
        }

        List<String> allLines;
        try {
             allLines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Problem z wczytaniem pliku exam. Spróbuj od początku");
            return;
        }
        List<String> passedExamTab = getPassedExam(passingTreshold, allLines);

        Path pathExamPassed = Paths.get("exam_passed.txt");
        try {
            Files.write(pathExamPassed, passedExamTab);
        } catch (IOException e) {
            System.out.println("Problem z zapisem pliku exam_passed. Spróbuj od początku");
            return;
        }
        System.out.println("Pliki zostały utworzone i zapisane");
    }


    private static List<String> getPassedExam(int passingTreshold, List<String> allLines) {
        List <String> passedExamTab = new ArrayList<>();
        for (int i = 0; i < allLines.size(); i++) {
            String line = allLines.get(i);
            int indexOfSpace = line.indexOf(" ");
            String subLine = line.substring(indexOfSpace+1);
            if(!NumberUtils.isDigits(subLine)) {
                continue;
            }
            int score;
            try {
                score = Integer.parseInt(subLine);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                continue;
            }
            if(score > passingTreshold){
                passedExamTab.add(line);
            }

        }
        return passedExamTab;
    }

    private static Path getPath(Scanner scan) {
        Path path = Path.of("exam.txt");
        while (true) {
            if (Files.isRegularFile(path)) {
                System.out.println("Podany plik już istnieje. Kontynuowanie programu oznacza jego nadpisanie. Czy chcesz kontynować (wciśnij Y / N)");
                String createNewFile = scan.nextLine().trim();
                if (!createNewFile.equalsIgnoreCase("y") && !createNewFile.equalsIgnoreCase("n")) {
                    System.out.print("Nie wprowadziłeś Y ani N. ");
                    continue;
                } else if (createNewFile.equalsIgnoreCase("n")) {
                    System.out.println("Program nie będzie kontynouowany, sprawdź nazwę pliku i włącz jeszcze raz");
                    return null;
                }
                break;
            }
            break;
        }
        return path;
    }

    private static String[] getExamData(int maxPointsNumber, Scanner scan, String input) {
        String[] examData = new String[Integer.parseInt(input)];
        for (int i = 0; i < examData.length; i++) {
            String inputLogin;
            String inputMark;
            while (true) {
                System.out.println("Podaj Twój login. Nie używaj spacji lub tabulatora");
                inputLogin = scan.nextLine().trim();
                if (StringUtils.containsAny(inputLogin, " ", "\t")) {
                    System.out.println("Nie uzywaj spacji ani tabulatra, podaj jeszcze raz");
                    continue;
                }
                break;
            }
            while (true) {
                System.out.println("Podaj liczbę punktów (zakres 0-" + maxPointsNumber + "). Nie używaj spacji lub tabulatora");
                inputMark = scan.nextLine().trim();
                if (!NumberUtils.isDigits(inputMark)) {
                    System.out.println("Podane dane są błędne. Nie podałeś liczby lub podałeś więcej niż jedną. Spróbuj jeszcze raz");
                    continue;
                }
                if (Integer.parseInt(inputMark) < 0 || Integer.parseInt(inputMark) > maxPointsNumber) {
                    System.out.println("Podane dane są błędne. Podałeś liczbę poza zakresem. Spróbuj jeszcze raz");
                    continue;
                }
                break;
            }
            examData[i] = inputLogin + " " + inputMark;
        }
        return examData;
    }

    private static String getNumberOfStudents(Scanner scan) {
        System.out.println("Podaj liczbe osób w grupie: ");
        String input;
        while (true) {
            input = scan.nextLine().trim();
            if (!NumberUtils.isDigits(input)) {
                System.out.println("Podane dane są błędne. Nie podałeś liczby lub podałeś więcej niż jedną. Podaj dokładnie jedną liczbę");
                continue;
            }
            break;
        }
        return input;
    }
}

