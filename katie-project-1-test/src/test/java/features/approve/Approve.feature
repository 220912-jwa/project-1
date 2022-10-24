Feature: Manager & Matrix

# Declarative Style

    Background: 
        Given The user is on the home page
        Given The user is a manager

    Scenario: Approve a reimbursement request
        When The manager enters the ID of an event
        When The manager clicks the approve button
        Then An alert with a success message should appear



