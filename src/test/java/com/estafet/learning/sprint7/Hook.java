//package com.estafet.learning.sprint7;
//
//import io.cucumber.java.After;
//
//import java.sql.SQLException;
//
//import static com.estafet.learning.sprint7.Globals.*;
//
//public class Hook extends ConnectComponent {
//
//    @After
//    public void cleanData() throws SQLException {
//        System.out.println("Clean tables");
//        truncateTable(tablesToWorkWith);
//    }
//
//    @After
//    public void dropTables() throws SQLException {
//        System.out.println("delete tables");
//        deleteTables(tablesToWorkWith3);
//    }
//
//    @After
//    public static void closeConnection() {
//        System.out.println("Close connection");
//        closeConnection();
//    }
//
//}
