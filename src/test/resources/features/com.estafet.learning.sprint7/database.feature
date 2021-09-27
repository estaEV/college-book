Feature: General operations using the DB
  Free text here about the feature.

  Scenario: Creating new DB tables

  Free text here related to the scenario

    Given A connection is open
    When New tables are created

    Then New tables should be present into the DB


  Scenario Outline: Healthy smotthies

  Free text here related to the scenario

    Given A connection is open
    When New tables are created
    Examples: Healthie smothie
    This table describes some of the helathie smoothies

      |Category| Somothie|Caloria|Flames|Range
      |Category| apple+bazz|120|2|Helathie
      |Category| peach+tzaziki|240|1|Helathie

    Examples: Indulgent smothie
    This table describes some of the not so healthy smoothies

      |Category| Somothie|Caloria|Flames|Range
      |Category| apple+bazz|120|2|Helathie
      |Category| peach+tzaziki|240|1|Helathie
    Then New tables should be present into the DB
