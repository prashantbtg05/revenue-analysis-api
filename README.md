## REVENUE ANALYSIS

Data Engineer Home Exercise


## BUILT WITH
Eclispe IDE
Java 1.8
Spring Boot
MySQL 3
Maven
Git


## GETTING STARTED


Clone project from github.

```bash
git clone https://github.com/prashantbtg05/revenue-analysis-api.git
```

Add Data Source details in application.properties file
property file contains keys already, please enter 'values' corresponding to your database

```2
 /src/main/resources/application.properties 
```


 
ALTER TABLES REVENUE_ANALYSIS & CALENDAR to include id column

```3
ATER TABLE TABLE_NAME
ADD ID INT
```

## BUILD WITH MAVEN

Run project in eclipse

```
RUN AS > MAVEN BUILD > GOALS =package
```

jar file is created nad path will me mentioned in console logs


## RUNNING APPLICATION

Execute following command in command prompt

```
java -jar jar_file_name.jar 
```


## TESTING APIs

checking all the member data in DB

```
http://localhost:8080/revenue
```

Revenue Data by member id 
** month and game_id parameters optional

```
http://localhost:8080/revenue/member/member_id
EXAMPLE - http://localhost:8080/revenue/member/1001
```

API for TOTAL WAGER AMOUNT by MEMBER_ID
** month and game_id parameters optional

```
http://localhost:8080/revenue/wager/member_id?month=month&game_id=game_id

EXAMPLE - http://localhost:8080/revenue/wager/1001
EXAMPLE - http://localhost:8080/revenue/wager/1001?month=201710&game_id=1100
EXAMPLE - http://localhost:8080/revenue/wager/1001?month=201710
EXAMPLE - http://localhost:8080/revenue/wager/1001?game_id=1100
```

API for TOTAL WIN AMOUNT by MEMBER_ID
** month and game_id parameters optional

```
http://localhost:8080/revenue/winamt/member_id?month=month&game_id=game_id

EXAMPLE - http://localhost:8080/revenue/winamt/1001
EXAMPLE - http://localhost:8080/revenue/winamt/1001?month=201710&game_id=1100
EXAMPLE - http://localhost:8080/revenue/winamt/1001?month=201710
EXAMPLE - http://localhost:8080/revenue/winamt/1001?game_id=1100
```

API for TOTAL COUNT OF WAGER by MEMBER_ID
** month and game_id parameters optional

```
http://localhost:8080/revenue/wagercount/member_id?month=month&game_id=game_id

EXAMPLE - http://localhost:8080/revenue/wagercount/1001
EXAMPLE - http://localhost:8080/revenue/wagercount/1001?month=201710&game_id=1100
EXAMPLE - http://localhost:8080/revenue/wagercount/1001?month=201710
EXAMPLE - http://localhost:8080/revenue/wagercount/1001?game_id=1100
```
