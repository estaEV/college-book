package com.estafet.learning.sprint7;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
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
    public void tablesAreCreated(String table) throws SQLException {
        tableNameHasToBePresentIntoTheDB(table);
        if ((resultSetTable == null || (!resultSetTable.equals(table)))) {
            comp.createTables(tablesToWorkWith3);
            tableNameHasToBePresentIntoTheDB(table);
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
                    resultSetTable = resultSet.getString(1);
                }
            }
        }
    }


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


    @Then("The new {} with {} {int} {int} has to be present into the DB")
    public void theNewStudentHasToBePresentIntoTheDB(String tableName, String objectName, int objectId, int objectYear) throws SQLException {
        String result = null;
        int result2 = 0;
        int result3 = 0;
        StringBuilder query = new StringBuilder();

        query
                .append("SELECT * FROM " + tableName + "s " +
                        System.getProperty("line.separator") +
                        "WHERE " + tableName + "Id" + " = " + objectId + ";");

        try (PreparedStatement preparedStatement = connection.
                prepareStatement(query.toString());) {

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    result = resultSet.getString(1);
                    result2 = resultSet.getInt(2);
                    result3 = resultSet.getInt(3);
                }
            }
        }
        assertEquals(objectName.trim(), result);
        assertEquals(objectId, result2);
        assertEquals(objectYear, result3);
    }


    @When("^Subject with (\\w+) (\\d+) (\\d+) is generated$")
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


    @When("Data from tables is removed")
    public void dataFromTablesIsRemoved() throws SQLException {
        comp.truncateTable(tablesToWorkWith);
    }

    @And("Tables are dropped")
    public void tablesAreDropped() throws SQLException {
        comp.deleteTables(tablesToWorkWith3);
    }

    @And("Connection is closed")
    public void connectionIsClosed() throws SQLException {
        ConnectComponent.closeConnection();
    }

    @Then("App is in idle")
    public void appIsInIdle() throws SQLException {
        assertTrue(connection.isClosed());
    }

    @Given("All other tests are executed")
    public void allOtherTestsAreExecuted() {
        assertNotNull(resultSetTable);
    }

    @When("Query for a specific year is executed")
    public void queryForASpecificYearIsExecuted(DataTable table) throws SQLException {
        List<List<String>> rows = table.asLists(String.class);
        for (List<String> row : rows) {
            double mathAvg = comp.mathAvgGrade(Integer.parseInt(row.get(0)));
        }
    }

}
