package com.estafet.learning.sprint7;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.valueOf;

public class ConnectComponent {

    public void tryConnection(double lowPrice, double highPrice) throws Exception {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college_book?user=admin2&password=admin2&serverTimezone=UTC");

             PreparedStatement preparedStatement = connection.
                     prepareStatement("SELECT * FROM products "
                             + "WHERE buyPrice between ? and ?");) {

            preparedStatement.setDouble(1, lowPrice);
            preparedStatement.setDouble(2, highPrice);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    System.out.println(resultSet.next());
                }
            }
        }
    }


    public void createTables(String[][] tablesToCreate) throws SQLException {

        for (int i = 0; i < tablesToCreate.length; i++) {

            // starts from 1
            StringBuilder params = new StringBuilder("");
            for (int j = 1; j < tablesToCreate[i].length; j++) {
                if (j != tablesToCreate[i].length-1) {
                    params.append("$col").append(String.valueOf(j)).append(", ");
                } else {
                    params.append("$col").append(String.valueOf(j));
                }
            }

            String strQuery =
                    "CREATE TABLE $tableName "
                            + "(" + params + "); ";
            for (int j = 1; j < tablesToCreate[i].length; j++) {
                strQuery = strQuery
                        .replace("$col" + j, tablesToCreate[i][j]);
            }
            strQuery = strQuery
                    .replace("$tableName", tablesToCreate[i][0]);


            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college_book?user=admin2&password=admin2&serverTimezone=UTC");

                 PreparedStatement preparedStatement = connection.
                         prepareStatement(strQuery);) {

                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            }
        }
    }

    public void deleteTables(String[][] tablesToDelete) throws SQLException {
        for (int i = 0; i < tablesToDelete.length; i++) {
            // Vulnerable to sql injection but still
            String strQuery = "DROP TABLE IF EXISTS "
                    + "$tableName;";
            String query = strQuery.replace("$tableName", tablesToDelete[i][0]);

            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college_book?user=admin2&password=admin2&serverTimezone=UTC");
                 PreparedStatement preparedStatement = connection.
                         prepareStatement(query);) {
                preparedStatement.executeUpdate();
            }
        }
    }

    public void insertStudentsData(String[] tablesToDelete, RandomGenerator deita) throws SQLException {

        List<Student> listStud = new ArrayList<>();
        listStud = deita.getStdList();

        for (int i = 0; i < listStud.size(); i++) {
            listStud.get(i);

            String strQuery =
                    "INSERT INTO $tableName "
                            + "(name, StudentId, classYear) "
                            + "VALUES (?, ?, ?)";

            String query = strQuery
                    .replace("$tableName", tablesToDelete[0]);

            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college_book?user=admin2&password=admin2&serverTimezone=UTC");

                 PreparedStatement preparedStatement = connection.
                         prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                preparedStatement.setString(1, listStud.get(i).getName());
                preparedStatement.setInt(2, listStud.get(i).getStudentId());
                preparedStatement.setInt(3, listStud.get(i).getClassYear());
                preparedStatement.executeUpdate();
            }
        }
    }

    public void insertSubjectsData(String[] tablesToDelete, RandomGenerator randData) throws SQLException {

        List<Subject> listSub = new ArrayList<>();
        listSub = randData.getSubList();

        for (int i = 0; i < listSub.size(); i++) {
            listSub.get(i);

            String strQuery =
                    "INSERT INTO $tableName "
                            + "(name, year) "
                            + "VALUES (?, ?)";

            String query = strQuery
                    .replace("$tableName", tablesToDelete[1]);

            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college_book?user=admin2&password=admin2&serverTimezone=UTC");

                 PreparedStatement preparedStatement = connection.
                         prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                preparedStatement.setString(1, listSub.get(i).getSubjectName());
                preparedStatement.setInt(2, listSub.get(i).getYearStudied());
                preparedStatement.executeUpdate();
            }
        }
    }

    public void insertNewSubject(String[] tablesToDelete, String newSubject, int subjectYear) throws SQLException {

            String strQuery =
                    "INSERT INTO $tableName "
                            + "(name, year) "
                            + "VALUES (?, ?)";

            String query = strQuery
                    .replace("$tableName", tablesToDelete[1]);

            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college_book?user=admin2&password=admin2&serverTimezone=UTC");

                 PreparedStatement preparedStatement = connection.
                         prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                preparedStatement.setString(1, newSubject);
                preparedStatement.setInt(2, subjectYear);
                preparedStatement.executeUpdate();
            }
        }



    public void truncateTable(String[] tablesToDelete) throws SQLException {

        for (int i = 0; i < tablesToDelete.length; i++) {

            String strQuery =
                    "TRUNCATE $tableName ";

            String query = strQuery
                    .replace("$tableName", tablesToDelete[i]);

            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college_book?user=admin2&password=admin2&serverTimezone=UTC");

                 PreparedStatement preparedStatement = connection.
                         prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                preparedStatement.setString(1, tablesToDelete[i]);

                preparedStatement.executeUpdate();
            }
        }
    }


}
