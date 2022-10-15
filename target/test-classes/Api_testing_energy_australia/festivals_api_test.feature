Feature: Testing Festival API

  @test
  Scenario: Verify API returns success status codes
    Given I call api "Festivals"
    When I see request "Success"
    Then I should get "200" status code





