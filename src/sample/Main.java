package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.java.works.GregorianCalendar;
import ru.java.works.Status;
import ru.java.works.Type;
import ru.java.works.db.Connector;
import ru.java.works.db.DatabaseWorker;
import ru.java.works.StudentWork;

import java.sql.SQLException;
import java.text.ParseException;
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
            DatabaseWorker.connect();
            DatabaseWorker.clearDB();
            DatabaseWorker.startTransaction();
            DatabaseWorker.addToDB(new StudentWork(
                    Type.COURSE_PROJECT,
                    "OOP",
                    null,
                    "ComputerNetworks",
                    new GregorianCalendar(2018, 6, 1),
                    Status.IN_PROCESS));
            DatabaseWorker.addToDB(new StudentWork(
                    Type.LABORATORY,
                    "OVP",
                    1,
                    "Фигурки двигать",
                    new GregorianCalendar(2018, 5, 12),
                    Status.NOT_STARTED));
            DatabaseWorker.addToDB(new StudentWork(
                    Type.ESSEY,
                    "Схемач",
                    null,
                    "Триггеры",
                    new GregorianCalendar(2018, 5, 13),
                    Status.IN_PROCESS));
            DatabaseWorker.addToDB(new StudentWork(
                    Type.EXAM,
                    "Теория алгоритмов",
                    null,
                    null,
                    new GregorianCalendar(2018, 7, 3),
                    Status.DONE));
            DatabaseWorker.commit();
            List<StudentWork> works = DatabaseWorker.getAll();
            for (StudentWork work: works){
                System.out.println(work.getDiscipline() + " " + work.getTheme());
            }
            Connector.getInstance().closeConnection();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

    }
}
