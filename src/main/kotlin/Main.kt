import kotlinx.coroutines.*
import java.time.LocalDate
import io.github.cdimascio.dotenv.dotenv

fun getTomorrowDate(): LocalDate {
    val today = LocalDate.now()
    val tomorrow = today.plusDays(1)
    return tomorrow
}

val dotenv = dotenv()
val apiKey = dotenv["API_KEY"]

private suspend fun getForecast(city: String) :WeatherData{
    val response = RetrofitClient.weatherAPIService.getForecast(
        city = city,
        date = getTomorrowDate().toString(),
        key = apiKey
    )
    return response
}

fun main() = runBlocking {
    println("API_KEY = $apiKey")
    val amstData = RetrofitClient.weatherAPIService.getForecast(
        city = "Amsterdam",
        date = getTomorrowDate().toString(),
        key = apiKey
    )
    println(amstData)
}