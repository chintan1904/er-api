Feature: ExchangeRate API Test feature file.

  Scenario Outline: Verify exchange rate GET api endpoint and check exchange rate is within bounds
    Given I call GET exchange rate api endpoint for "<base_currency>"
    Then I receive api response with status code as "<status_code>"
    And I verify result value in response body as "<result>"
    And I verify that "<number_of_currencies>" are returned by endpoint
    And I verify exchange rate for currency "<currency_code>" is between "<lower_boundary>" and "<upper_boundary>"
    Examples:
      | base_currency | status_code | result  | number_of_currencies | currency_code | lower_boundary | upper_boundary |
      | USD           | 200         | success | 162                  | AED           | 3.6            | 3.7            |