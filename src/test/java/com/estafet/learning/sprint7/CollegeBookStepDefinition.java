package com.estafet.learning.sprint7;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class CollegeBookStepDefinition {
    // Open a connection


    @Given("A connection is open")
    public void a_connection_is_open() {
        ConnectComponent comp = new ConnectComponent();
        assertNotNull(comp);
    }

    @When("New tables are created")
    public void new_tables_are_created() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("New tables should be present into the DB")
    public void new_tables_should_be_present_into_the_db() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }



}
