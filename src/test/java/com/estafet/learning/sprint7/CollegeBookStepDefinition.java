package com.estafet.learning.sprint7;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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
