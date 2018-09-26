Feature: Shopping Cart
    Scenario: Adding multiple q-ty of single product
        Given User is on home page
        When User goes to bestsellers in digital cameras
        When User opens details of 5 product
        When Full product name is available
        When Price is available
        When Qty of 1 is selected
        When User adds order to shopping cart
        When User reject further offers
        When User goes to shopping cart
        Then Correct product was added to cart
        Then Subtotal price sum is correct