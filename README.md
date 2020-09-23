------------
NBP ExchangeRatesApplication (in progress)
------------
##### Spring application using Spring Boot, Spring Web. The application reads data from the NBP api. Testing using Postman ######

------------

**Table** - table type</br>
**No** - table number</br>
**TradingDate** - date of listing (applies to table C)</br>
**EffectiveDate** - date of publication</br>
**Rates** - a list of exchange rates for individual currencies in the table</br>
**Country** - name of the country</br>
**Symbol** - currency symbol (numeric, applies to archival rates)</br>
**Currency** - currency name</br>
**Code** - currency code</br>
**Bid** - converted currency purchase rate (applies to table C)</br>
**Ask** - converted currency sale rate (applies to table C)</br>
**Mid** - converted average exchange rate of currency (applies to tables A and B)


Run application and go to view in browser: **localhost:8080** or try in Postman.

version 1.4 (src update)
------------
##### Version with thymeleaf view allows to check the exchange rate of a single currency and check the table (a or b) of currencies. So far the version in Postman is slightly different and gives you the option of checking a single currency by date or period of dates #####

in Postman (localhost:8080):

**Single Currency from today (table "A" only) : /api/{table}/{code}/{date}**</br>
=======
**Single Currency from today  : /api/{table}/{code}/{date}**</br>

Examples:</br>
• /api/a/usd/2020-04-04 ->>> Dollar USA </br>
• /api/a/eur/2020-03-30 ->>> Euro</br>

Date pattern: yyyy-MM-dd

**Single Currency from a certain period of time (table "A" only) : /api/{table}/{code}/{startDate}/{endDate}**  
=======
**Single Currency from a certain period of time : /api/{table}/{code}/{startDate}/{endDate}**  
 

• /api/a/gbp/2020-03-20/2020-04-04 ->>> Pound UK</br>

