This Kotlin program fetches the forecast for the next day for Chisinau, Madrid, Amsterdam, and Kyiv from the Weather API. It then displays it in a table in STDOUT. For API interactions, I used Retrofit. I used Gradle as the package manager. I used Moshi for JSON conversion. 

Although the challenge description outlined dates as table columns, the challenge also asked only for tomorrow's forecast, so one column would be insufficient to print all the data. Therefore, I made the columns by the metrics. This is an example of output by the program

```
City            | Min Temp (°C)   | Max Temp (°C)   | Humidity (%)    | Wind Speed (kph) | Wind Dir       
----------------------------------------------------------------------------------------------------
Amsterdam       | 13.4            | 19.4            | 75              | 27.0            | WSW            
Chisinau        | 13.4            | 27.8            | 56              | 24.8            | SE             
Madrid          | 16.5            | 30.0            | 40              | 21.2            | W              
Kyiv            | 14.6            | 25.2            | 35              | 21.2            | SE
```         
