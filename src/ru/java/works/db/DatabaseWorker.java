package ru.java.works.db;


import ru.java.works.GregorianCalendar;
import ru.java.works.Status;
import ru.java.works.StudentWork;
import ru.java.works.Type;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class DatabaseWorker {
    private static Connector connector = Connector.getInstance();
    private static Connection connection;
    private static Statement statement;



    private static String query;

    public static void connect() throws SQLException {
        if (connection == null || !connector.isOpen()) {
            connection = connector.connectToDB();
            statement = connection.createStatement();
        }
    }

    public static void addToDB(StudentWork work) throws SQLException {
        query = "INSERT INTO data (distipline, type, number, theme, deadline, status) " +
                "values (\'" + work.getDiscipline() + "\',\'"
                + work.getType() + "\',\'"
                + work.getNumber() + "\', \'"
                + work.getTheme() + "\',\'"
                + work.getDeliveryDate() + "\',\'"
                + work.getStatus() + "\');";
        statement.execute(query);
    }
    public static List<StudentWork> getAll() throws SQLException, ParseException {
        query = "SELECT * FROM data";
        ResultSet rs = statement.executeQuery(query);
        List<StudentWork> list = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy г");
        while(rs.next()){
            list.add(new StudentWork(
                    Type.valueOf(rs.getString(3)),
                    rs.getString(2),
                    rs.getInt(4),
                    rs.getString(5),
                    new GregorianCalendar(format.parse(rs.getString(6)).getTime()),
                    Status.valueOf(rs.getString(7))));
        }
        return list;
    }

    /*public static void setStatus(Status status, StudentWork work) throws SQLException {
        query = "UPDATE data SET status = \'" + status + "\' " +
                "WHERE deadline = \'" + work.getDeliveryDate() + "\' AND " +
                "distipline = \'" + work.getDiscipline() + "\' AND " +
                "type = \'" + work.getType() + "\' AND " +
                "number = \'" + work.getNumber() + "\' AND " +
                "theme = \'" + work.getTheme() + "\'";
        statement.executeUpdate(query);
    }*/

    public static void clearDB() throws SQLException {
        query = "DELETE from data";
        statement.execute(query);
    }

    public static void startTransaction() throws SQLException {
        connection.setAutoCommit(false);

    }
    public static void commit() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }
}
