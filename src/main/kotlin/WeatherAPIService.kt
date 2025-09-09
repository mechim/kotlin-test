import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {
    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("days") days: Int=1,
        @Query("dt") date: String,
        @Query("alerts") alerts: String = "no",
        @Query("aqi") aqi: String = "no",
        @Query("hour") hour: Int = 12, //don't need all 24 hours in the response
        @Query("key") key: String,
    ): WeatherData
}