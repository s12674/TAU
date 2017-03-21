
Scenario:  Rise and Shine! The Pancake Queen, the Ladybug Queen and ten of their closest
friends have fallen under a sleeping spell and it's your job to wake them up!

Given We re getting some <alarms> to set alarm clock for her
When When Your alarm and actual time: <actualDate> will be almost same, You will hear some noises
Then This is the result: <result> when its true You are hero who saved Queen! :D

Examples:
|alarms|actualDate|result|
|120119941200|120119941200|true|
|120119941200|120119941200|true|
|120119941200|120119942000|false|
|120119941200|120119941200|true|
