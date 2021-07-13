package pl.coderslab.exam1;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main08 {
//3 Solutions in code

    public static void main(String[] args) {
        create(71);
    }

    public static void create(int max) {
        int maxPointsNumber = max;
        int passingTreshold = (int) (max * 0.6);
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
//2nd Solution - saves in different file and uses Array instead of a list
        String stringTo2ndExamFile = "exam2.txt";
        try(FileWriter fileWriter = new FileWriter(stringTo2ndExamFile)) {
            for (String row : examData) {
                fileWriter.append(row).append("\n");
            }
        } catch (IOException e){
            System.out.println("Plik exam nie zostal zapisany. Spróbuj od początku");
            return;
        }
//End of Section

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


//2nd Solution - use of File class + Arrays instead of lists
        File exam2ndFile = new File(stringTo2ndExamFile);
        int counter = 0;
        try (Scanner scanner = new Scanner(exam2ndFile)){
            while(scanner.hasNextLine()) {      //Solution without using copyOf
                counter++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File can't be found. Check the directory and try one again");
            return;
        }
        String[][] examLine = new String[counter][];
        try(Scanner scanner = new Scanner(exam2ndFile)) {
            for (int i = 0; i < examLine.length; i++) {
                examLine[i] = scanner.nextLine().split(" ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File can't be read. Check the directory and the file and try once again");
            return;
        }
        System.out.println("Test - deep to String: " + Arrays.deepToString(examLine));
        try{                                                                  //this time without "try with resources" - as an another possibility
            PrintWriter printWriter = new PrintWriter("exam_passed2.txt");
            for (int i = 0; i < examLine.length; i++) {
                if (Integer.parseInt(examLine[i][1]) > passingTreshold)
                    printWriter.println(examLine[i][0] + " " + examLine[i][1]);
            }
            printWriter.close();
            System.out.println("Second file with positive exam results was written");
        } catch (FileNotFoundException e){
            System.out.println("File can't be written. Check the directory and try once again");
            return;
        }
// End of Section - 2nd Solution

//3rd Solution - faster version of type 2 Solution (without saving all data in separate Array/List)

        try(Scanner scanner3 = new Scanner(exam2ndFile); FileWriter filewriter = new FileWriter("exam_passed3.txt")){
            while(scanner3.hasNextLine()){
                String[] lineInFile = scanner3.nextLine().trim().split(" ");
                int scoreFile2;
                try{
                    scoreFile2 = Integer.parseInt(lineInFile[1]);
                } catch (NumberFormatException e){
                    System.out.println("Błąd. Nie występuje liczba");
                    continue;
                }
                if(scoreFile2 > passingTreshold){
                    filewriter.append(lineInFile[0]).append(" ").append(lineInFile[1]).append("\n");
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("plik nie został znaleziony");
        } catch (IOException e){
            System.out.println("nie udało się zapisać pliku");
        }

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
                    return null; //NEW
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

