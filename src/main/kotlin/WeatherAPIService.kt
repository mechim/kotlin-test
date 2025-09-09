import retrofit2.http.GET

interface WeatherAPIService {
    @GET("/forecast.json")
    suspend fun getForecast(): WeatherData
}