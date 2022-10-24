Feature: Manager & Matrix

# Declarative Style

    Background: 
        Given The user is on the submitEvent page

    Scenario: Create a New Reimbursement Request
        Given The user is on the submitEvent page
        When The employee types in 2 into the Event ID input
        When The employee types in 100 into the cost input
        When The employee types in yes into the Event Name input
        When The employee types in 100 into the cost input
        When The employee types in 1100 into the time input
        When The employee types in no into the description input
        When The employee types in no into the justification input
        When The employee types in no into the grading format input
        When The employee selects todays date for start date
        When The employee selects todays date for end date
        When The employee clicks submit
        Then An alert with a success message should appear

