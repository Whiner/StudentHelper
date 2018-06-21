package ru.java.works;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWorker {
    public static void toFile(StudentWork studentWork){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data.txt", true))){
            bufferedWriter.newLine();
            bufferedWriter.write("[" + studentWork.getDiscipline() + "]\n");
            bufferedWriter.write("Тип: " + studentWork.getType() + "\n");
            if(studentWork.getNumber() == null){
                bufferedWriter.write("Номер: - \n");
            } else {
                bufferedWriter.write("Номер: " + studentWork.getNumber() + "\n");
            }
            bufferedWriter.write("Тема: " + studentWork.getTheme() + "\n");
            bufferedWriter.write("Дата сдачи: " + studentWork.getDeliveryDate().toString() + "\n");
            bufferedWriter.write("Статус: " + studentWork.getStatus() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static /*List<StudentWork> */ void fromFile(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))){
            String current_string;
            String discipline = "\\[(.+)]";
            String type = "Тип:\\s(.+)";
            String number = "Номер:\\s(.+)";
            String theme = "Тема:\\s(.+)";
            String delivery = "Дата сдачи:\\s(.+)";
            String status = "Статус:\\s(.+)";

            Pattern discipline_Pattern = Pattern.compile(discipline);
            Pattern type_Pattern = Pattern.compile(type);
            Pattern number_Pattern = Pattern.compile(number);
            Pattern theme_Pattern = Pattern.compile(theme);
            Pattern delivery_Pattern = Pattern.compile(delivery);
            Pattern status_Pattern = Pattern.compile(status);

            Matcher matcher;

            while((current_string = bufferedReader.readLine()) != null){
                matcher = discipline_Pattern.matcher(current_string);
                if(matcher.find()){
                    System.out.println(matcher.group(1));

                    current_string = bufferedReader.readLine();
                    matcher = type_Pattern.matcher(current_string);
                    if(matcher.find()){
                        System.out.println(matcher.group(1));
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }

                    current_string = bufferedReader.readLine();
                    matcher = number_Pattern.matcher(current_string);
                    if(matcher.find()){
                        System.out.println(matcher.group(1));
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }

                    current_string = bufferedReader.readLine();
                    matcher = theme_Pattern.matcher(current_string);
                    if(matcher.find()){
                        System.out.println(matcher.group(1));
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }

                    current_string = bufferedReader.readLine();
                    matcher = delivery_Pattern.matcher(current_string);
                    if(matcher.find()){
                        System.out.println(matcher.group(1));
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }

                    current_string = bufferedReader.readLine();
                    matcher = status_Pattern.matcher(current_string);
                    if(matcher.find()){
                        System.out.println(matcher.group(1));
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
