package ru.java.works;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {

    private static String filename = "data.txt";

    public static void toFile(StudentWork studentWork) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {
            bufferedWriter.newLine();
            bufferedWriter.write("[" + studentWork.getDiscipline() + "]\n");
            bufferedWriter.write("Тип: " + studentWork.getType() + "\n");
            if (studentWork.getNumber() == null) {
                bufferedWriter.write("Номер: -\n");
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

    public static List<StudentWork> fromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        List<StudentWork> list = new ArrayList<>();
        String current_string;
        String discipline = "\\[(.+)]";
        String type = "Тип:\\s(.+)";
        String number = "Номер:\\s(.+)";
        String theme = "Тема:\\s(.+)";
        String delivery = "Дата сдачи:\\s(.+)";
        String status = "Статус:\\s(.+)";

        String temp;

        while ((current_string = bufferedReader.readLine()) != null) {
            StudentWork studentWork = new StudentWork();
            try {
                temp = Parser.parse(current_string, discipline);
                if (temp != null) {
                    studentWork.setDiscipline(temp);
                    temp = Parser.parse(bufferedReader.readLine(), type);
                    if (temp != null) {
                        studentWork.setType(Type.valueOf(temp));
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }

                    temp = Parser.parse(bufferedReader.readLine(), number);
                    if (temp != null) {
                        if (!temp.equals("-")) {
                            studentWork.setNumber(Integer.valueOf(temp));
                        }
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }
                    temp = Parser.parse(bufferedReader.readLine(), theme);
                    if (temp != null) {
                        studentWork.setTheme(temp);
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }
                    temp = Parser.parse(bufferedReader.readLine(), delivery);
                    if (temp != null) {
                        GregorianCalendar gc = new GregorianCalendar();
                        gc.fromString(temp, new SimpleDateFormat("dd MMM yyyy г"));
                        studentWork.setDeliveryDate(gc);
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }
                    temp = Parser.parse(bufferedReader.readLine(), status);
                    if (temp != null) {
                        studentWork.setStatus(Status.valueOf(temp));
                    } else {
                        throw new Exception("Структура файла повреждена");
                    }

                    list.add(studentWork);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
