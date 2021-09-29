Feature: General operations using the DB
  Free text here about the feature.

#  Scenario: Creating new DB tables
#  Free text here related to the scenario
#
#    Given A connection is open
#    When Table "tableName" is created
#      | students   |
#      | subjects   |
#      | gradebooks |


  Background:
    When A connection is open

  Scenario Outline: Creating new DB tables
  Free text here related to the scenario

    When Table <Table name> is created
    Then <Table name> has to be present into the DB

    Examples:
      | Table name |
      | students   |
      | subjects   |
      | gradebooks |


  Scenario Outline: Generating custom student data

#    Given students has to be present into the DB
    Given Table students is created
    When Student with <name> <studentId> <classYear> is generated
    Then The new student with  <name> <studentId> <classYear> has to be present into the DB
    Examples:
      | name   | studentId | classYear |
      | Pesho  | 33333     | 2016      |
      | Ivan   | 33335     | 2016      |
      | Dragan | 33336     | 2017      |


  Scenario Outline: Generating custom subject data

    Given Table subjects is created
    When Subject with <subjectName> <subjectId> <yearStudied> is generated
    Then The new subject with <subjectName> <subjectId> <yearStudied> has to be present into the DB
    Examples:
      | subjectName | subjectId | yearStudied |
      | CS          | 60000     | 2016        |
      | Economics   | 60001     | 2016        |
      | Pharmacy    | 600002    | 2017        |
