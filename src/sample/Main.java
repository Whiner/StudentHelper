package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import ru.java.works.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);

        try {
            final List<StudentWork> studentWorks = FileWorker.fromFile();
            for (StudentWork work: studentWorks){
                System.out.println(work.getDiscipline());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
