Feature: Login

    Scenario Outline: Login with correct credentials
        Given The employee is on the login page
        When  The employee types "<username>" into username input 
        When The employee types "<password>" into password input
        When The employee clicks on the login button
        Then The employee should see their name "<fname>" on the home page
    
    Examples:
        | username     | password | fname    |
        | grandma      | password | Georgine |
        | scoobydoo    | towander | Scooter  |
        | loodledoodle | moths1   | Lulu     |

