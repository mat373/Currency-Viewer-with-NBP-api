
# NBP ExchangeRatesApplication 
Spring application using Spring Boot, Spring Web. The application reads data from the NBP api. Testing using Postman 

------------


| * | * |
| ------ | ------ |
| Table | table type |
| No | table number |
| Trading Date | date of listing (applies to table C) |
| EffectiveDate | date of publication |
| Rates | a list of exchange rates for individual currencies in the table |
| Country | name of the country |
| Symbol | currency symbol (numeric, applies to archival rates) |
| Currency | currency name |
| Code | currency code |
| Bid | converted currency purchase rate (applies to table C) |
| Ask |converted currency sale rate (applies to table C)|
| Mid | converted average exchange rate of currency (applies to tables A and B) |



Run application and go to view in browser: **localhost:8080** or try in Postman.

version 1.4 (src update)
------------
 Version with thymeleaf view allows to check the exchange rate of a single currency and check the table (a or b) of currencies. So far the version in Postman is slightly different and gives you the option of checking a single currency by date or period of dates

in Postman (localhost:8080):

* Single Currency from today (table "A" only) : 

```sh
/api/{table}/{code}/{date}**
```

* Single Currency from today  : 

```sh
/api/{table}/{code}/{date}**
```

Examples:
• /api/a/usd/2020-04-04 ->>> Dollar USA 
• /api/a/eur/2020-03-30 ->>> Euro

Date pattern: yyyy-MM-dd

* Single Currency from a certain period of time (table "A" only) : 

```sh
/api/{table}/{code}/{startDate}/{endDate}**  
```

* Single Currency from a certain period of time : 

```sh
/api/{table}/{code}/{startDate}/{endDate}**  
```


 Example:
• /api/a/gbp/2020-03-20/2020-04-04 ->>> Pound UK


