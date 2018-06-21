package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.java.works.*;


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

        /*FileWorker.toFile(new StudentWork(Type.LABORATORY,
                "БЖД",
                1,
                "Как закрыть сессию за 250р",
                new GregorianCalendar(2018, 6, 23),
                Status.IN_PROCESS));

        FileWorker.toFile(new StudentWork(Type.COURSE_PROJECT,
                "ООП",
                null,
                "Как закрыть сессию за 250р",
                new GregorianCalendar(2018, 6, 23),
                Status.IN_PROCESS));*/

        FileWorker.fromFile();
    }
}
