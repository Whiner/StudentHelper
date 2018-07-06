package ru.java.works.db;

public class DBStatus {
    private static boolean connected = false;
    private static boolean createdStatement = false;

    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        DBStatus.connected = connected;
    }

    public static boolean isCreatedStatement() {
        return createdStatement;
    }

    public static void setCreatedStatement(boolean createdStatement) {
        DBStatus.createdStatement = createdStatement;
    }
}
