Feature: Add a product to the shopping cart wong

  Scenario Outline: Add a product to the shopping cart
    Given "Candidate" select the <article>
    When Add to shopping cart the <product>
    Then Check if the product was added to the cart <product>

    Examples:
      | article     | product   |
      | Candidate   | Candidate |
