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

24.03 - version 1.3
------------
##### Version with thymeleaf view allows to check the exchange rate of a single currency and check the table (a or b) of currencies. So far the version in Postman is slightly different and gives you the option of checking a single currency by date or period of dates #####

in Postman (localhost:8080):

**Single Currency from today (table "A" only) : /api/{code}**</br>
Examples:</br>
• /api/usd ->>> Dollar USA </br>
• /api/eur ->>> Euro</br>
• /api/gbp ->>> Pound UK</br>

Date pattern: yyy-MM-dd

**Single Currency from some date (table "A" only) : /api/{code}/{date}**  

• /api/usd/2020-03-10 ->>> Dollar USA from March 10, 2020

**Single Currency from a certain period of time (table "A" only) : /api/{code}/{startDate}/{endDate}**  

• /api/usd/2020-03-10/2020-03-20 ->>> Dollar USA from March 10 to March 20 2020

