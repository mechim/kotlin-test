import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://www.weatherapi.com"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val weatherAPIService: WeatherAPIService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory((MoshiConverterFactory.create(moshi)))
            .build()
            .create(WeatherAPIService::class.java)
    }
}