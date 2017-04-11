Scenario: User is trying to login with wrong password
Given user is on login form page
When user inserts login: lol in input with name: user
Then user inserts password: lol in input with name: haslo
When user clicks button with id: zaloguj
Then site displays failed login text in div with id: failed


Scenario: User is trying to login with good credentials
Given user is on login form page
When user inserts login: admin in input with name: user
Then user inserts password: admin in input with name: haslo
When user clicks button with id: zaloguj
Then site message after trying to log: success

Scenario: User is checking if his sessios is saved on site
Given user is on Home page
Then site contains link with text: wyloguj
Then user clicks on link with text: logowanie
Then check if session is good: true

Scenario: User is checking if his session is destroyed after logout
Given user is on Home page
Then site contains link with text: wyloguj
Then user clicks on link with text: wyloguj
Then check if session is good: false

