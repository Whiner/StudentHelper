package ru.java.works;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static String parse(String source, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        if(matcher.find()){
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
