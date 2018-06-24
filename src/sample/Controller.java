package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.java.works.StudentWork;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    TableView<StudentWork> table;



    private void createTaskTable(){
        if(table.getColumns().size() == 0) {
            table.getColumns().clear();
            TableColumn<StudentWork, String> number = new TableColumn<>("Номер работы");
            TableColumn<StudentWork, String> delivery = new TableColumn<>("Дата сдачи");
            TableColumn<StudentWork, String> discipline = new TableColumn<>("Дисциплина");
            TableColumn<StudentWork, String> type = new TableColumn<>("Вид");
            TableColumn<StudentWork, String> status = new TableColumn<>("Статус");

            number.setCellValueFactory(new PropertyValueFactory<>("number"));
            delivery.setCellValueFactory(new PropertyValueFactory<>("delivery"));
            discipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));
            type.setCellValueFactory(new PropertyValueFactory<>("type"));
            status.setCellValueFactory(new PropertyValueFactory<>("status"));

            number.setMinWidth(300);
            delivery.setMinWidth(200);
            discipline.setMinWidth(200);
            type.setMinWidth(200);
            status.setMinWidth(200);

            table.getColumns().addAll(number, delivery, discipline, type, status);
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTaskTable();
    }
}
