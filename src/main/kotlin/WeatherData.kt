import com.squareup.moshi.Json

// Root
data class WeatherData(
    val forecast: Forecast?
)

// --- forecast section ---
data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val day: Day,
    val hour: List<Hour>
)

// --- day-level info ---
data class Day(
    @Json(name = "maxtemp_c") val maxTempC: Double,
    @Json(name = "mintemp_c") val minTempC: Double,
    @Json(name = "avghumidity") val avgHumidity: Int,
    @Json(name = "maxwind_kph") val maxWindKph: Double
)

// --- hour-level info ---
data class Hour(
    @Json(name = "wind_dir") val windDir: String
)