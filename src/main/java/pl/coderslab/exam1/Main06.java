package pl.coderslab.exam1;

import org.apache.commons.lang3.StringUtils;

public class Main06 {
//2 Solutions
    public static void main(String[] args) {
        String str = "Napis do zmiany w metodzie";
        String forReplace = null;
        String replacement = "zmieniający";
        System.out.println("Napis po zmianie: " + replaceStr2(str,forReplace,replacement));
    }

    public static String replaceStr(String str, String forReplace, String replacement){
        if(str == null || forReplace == null || replacement == null){
            return "Wprowadzone dane zawierają null. Wprowadź dane jeszcze raz";
        }
        return str.replace(forReplace, replacement);
    }

//2nd Solution - null safe

    public static String replaceStr2(String str, String forReplace, String replacement){
        return StringUtils.replace(str, forReplace, replacement);
    }

}
