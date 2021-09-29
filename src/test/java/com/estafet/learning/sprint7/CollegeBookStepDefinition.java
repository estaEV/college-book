package com.estafet.learning.sprint7;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static com.estafet.learning.sprint7.Globals.*;

public class CollegeBookStepDefinition {

    ConnectComponent comp = null;
    String resultSetTable = null;

    @Given("A connection is open")
    public void a_connection_is_open() {
        comp = new ConnectComponent();
        assertNotNull(comp);
    }

    @When("^Tables? (\\w+) (?:are|is) created$")
    //@When("Table {string} is created")
    public void tablesAreCreated (String table) throws SQLException {
        tableNameHasToBePresentIntoTheDB(table);
        if (!(table.equals(resultSetTable))) {
            comp.createTables(tablesToWorkWith3);
        }
        assertEquals(table, resultSetTable);
    }


    @Then("^(\\w+) (?:has|is) to be present into the DB$")
    public void tableNameHasToBePresentIntoTheDB(String table) throws SQLException {
        StringBuilder query = new StringBuilder();

        query
                .append("SHOW TABLES LIKE ")
                .append(System.getProperty("line.separator"))
                .append("'").append(table).append("'")
                //.replace(0, 0, "").replace(table.length(), table.length(), "'");
                .append(";");

        try (PreparedStatement preparedStatement = connection.
                prepareStatement(query.toString());) {

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println("preparedStatement is: " + preparedStatement);
                    //resultSetTable = resultSet.getString("Tables_in_college_book (" + table + ")");
                    resultSetTable = resultSet.getString(1);
                }
            }
        }
        assertEquals(table, resultSetTable);
    }

    //@When("Student with {word} {int} {int} is generated")
    @When("^Student with (\\w+) (\\d+) (\\d+) is generated$")
    public void recordWithNameSubjectGradeIsGenerated(String name, int studentId, int classYear) throws SQLException {
        Student fok = new Student();
        RandomGenerator randData = new RandomGenerator();
        List<Student> stdList = new ArrayList<>();

        fok.setName(name);
        fok.setStudentId(studentId);
        fok.setClassYear(classYear);
        stdList.add(fok);
        randData.setStdList(stdList);
        comp.insertStudentsData(tablesToWorkWith, randData);
    }

// TO DO: Merge that with the preious method
    @Then("The new student with {} {int} {int} has to be present into the DB")
    public void theNewStudentHasToBePresentIntoTheDB(String studentName, int studentId, int classYear) throws SQLException {
        String result = null;
        int result2 = 0;
        int result3 = 0;
        StringBuilder query = new StringBuilder();

        query
                .append("SELECT * FROM students ")
                .append(System.getProperty("line.separator"))
                .append("WHERE studentId = ").append(studentId)
                .append(";");

        try (PreparedStatement preparedStatement = connection.
                prepareStatement(query.toString());) {

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println("preparedStatement is: " + preparedStatement);
                    //resultSetTable = resultSet.getString("Tables_in_college_book (" + table + ")");
                    result = resultSet.getString(1);
                    result2 = resultSet.getInt(2);
                    result3 = resultSet.getInt(3);
                }
            }
        }
        System.out.println("result:" + result.trim());
        assertEquals(studentName.trim(), result);
        assertEquals(studentId, result2);
        assertEquals(classYear, result3);
    }

    @When("^Subject with (\\w+) (\\d+) (\\d+) is generated$$")
    public void subjectWithSubjectNameSubjectIdYearStudiedIsGenerated(String subjectName, int subjectId, int yearStudied) throws SQLException {
        Subject subObj = new Subject();
        RandomGenerator randData = new RandomGenerator();
        List<Subject> subList = new ArrayList<>();

        subObj.setSubjectName(subjectName);
        subObj.setSubjectId(subjectId);
        subObj.setYearStudied(yearStudied);
        subList.add(subObj);
        randData.setSubList(subList);
        comp.insertSubjectsData(tablesToWorkWith, randData);


    }

    @Then("^The new subject with (\\w+) (\\d+) (\\d+) has to be present into the DB$")
    public void SubjectHasToBePresentIntoTheDB(String subjectName, int subjectId, int yearStudied) throws SQLException {
        String result = null;
        int result2 = 0;
        int result3 = 0;
        StringBuilder query = new StringBuilder();

        query
                .append("SELECT * FROM subjects ")
                .append(System.getProperty("line.separator"))
                .append("WHERE subjectId = ").append(subjectId)
                .append(";");

        try (PreparedStatement preparedStatement = connection.
                prepareStatement(query.toString());) {

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println("preparedStatement is: " + preparedStatement);
                    //resultSetTable = resultSet.getString("Tables_in_college_book (" + table + ")");
                    result = resultSet.getString(1);
                    result2 = resultSet.getInt(2);
                    result3 = resultSet.getInt(3);
                }
            }
        }
        System.out.println("result:" + result);
        assertEquals(subjectName.trim(), result.trim());
        assertEquals(subjectId, result2);
        assertEquals(yearStudied, result3);
    }

}
