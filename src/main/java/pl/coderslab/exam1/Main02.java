package pl.coderslab.exam1;

public class Main02 {
    public static void main(String[] args) {
        String toShorten = "Naucz się programować";
        int numberOfLetters = 7;
        System.out.println("Napis oryginalny: " + toShorten);
        System.out.println("Napis po skrócie: " + shorten(toShorten,numberOfLetters));
    }

    public static String shorten(String str, int length){
        return str.substring(0,length);
    }


}
