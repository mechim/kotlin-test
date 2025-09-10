import kotlinx.coroutines.*
import java.time.LocalDate
import io.github.cdimascio.dotenv.dotenv

fun getTomorrowDate(): LocalDate = LocalDate.now().plusDays(1)

val dotenv = dotenv()
val apiKey = dotenv["API_KEY"]

private suspend fun getForecast(city: String): WeatherData {
    return RetrofitClient.weatherAPIService.getForecast(
        city = city,
        date = getTomorrowDate().toString(),
        key = apiKey
    )
}

fun main() = runBlocking {
    val cities = listOf("Amsterdam", "Chisinau", "Madrid", "Kyiv")

    // fetch all forecasts concurrently
    val forecasts = cities.associateWith { city ->
        async { getForecast(city) }
    }.mapValues { it.value.await() }

    println(
        listOf("City", "Min Temp (°C)", "Max Temp (°C)", "Humidity (%)", "Wind Speed (kph)", "Wind Dir")
            .joinToString(" | ") { it.padEnd(15) }
    )
    println("-".repeat(100))

    for ((city, data) in forecasts) {
        val day = data.forecast?.forecastday?.getOrNull(0)?.day
        val hour = data.forecast?.forecastday?.getOrNull(0)?.hour?.getOrNull(0)

        val minTemp = day?.minTempC?.toString() ?: "-"
        val maxTemp = day?.maxTempC?.toString() ?: "-"
        val humidity = day?.avgHumidity?.toString() ?: "-"
        val windSpeed = day?.maxWindKph?.toString() ?: "-"
        val windDir = hour?.windDir ?: "-"

        println(
            listOf(city, minTemp, maxTemp, humidity, windSpeed, windDir)
                .joinToString(" | ") { it.padEnd(15) }
        )
    }
}
