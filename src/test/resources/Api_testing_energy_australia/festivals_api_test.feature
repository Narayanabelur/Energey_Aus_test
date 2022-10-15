Feature: Testing Festival API

  @test
  Scenario: Verify API returns success status codes
    Given I call api "Festivals"
    When I see request "Success"
    Then I should get "200" status code

  Scenario: Verify API returns throttled status codes
      Given I call api "Festivals"
      When I see request "Throttled"
      Then I should get "429" "status code"

  Scenario: Verify API response has a valid data
    Given I call api "Festivals"
    When I see request "Success"
    Then I should see "Music Festival Name" "LOL-palooza"
    And I should see "Music Festival Name" "Twisted Tour"
    And I should see "Music Festival Name" "Trainerella"

  Scenario: Verify a Band is in correct Music festival
    Given I call api "Festivals"
    And I see request "Success"
    And I should see "Jill Black" band in "LOL-palooza"
    And I should see "Summon" band in "Twisted Tour"
    And I should see "Manish Ditch" band in "Trainerella"

  Scenario: Verify recordLabels belong correct bands
    Given I call api "Festivals"
    And I see request "Success"
    And I should see record label "Outerscope" in band "Squint-281"
    And I should see record label "Pacific Records" in band "Propeller"


