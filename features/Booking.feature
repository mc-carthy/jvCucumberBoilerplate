Feature: Booking a spa day

    Customers should be able to book a spa day at a range of locations and dates

    Scenario: Booking a valid spa day

        Given I am on the Aquasana home page
        When I select Spa Days
        And I select Sherwood Forest from the Choose Your Spa dropdown
        And I choose a day 14 days from now in the Date dropdown
        And I set 2 days on the Flexibility dropdown
        And I click Search Now
        Then I should see many search results
        When I select More Information on the number 1 result
        And I select the first available date
        And I choose 2 guests
        And I book my selection