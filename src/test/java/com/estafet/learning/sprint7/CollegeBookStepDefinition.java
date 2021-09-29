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

        try {
            comp.createTables(tablesToWorkWith3);
        } catch (SQLException e) {}

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
        }


    @Then("^(\\w+) has to be present into the DB$")
    public void tableNameHasToBePresentIntoTheDB(String table) {
        assertEquals(table, resultSetTable);
    }

    @When("New {} is generated")
    public void newDataIsGenerated(String table) throws SQLException {

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

}
