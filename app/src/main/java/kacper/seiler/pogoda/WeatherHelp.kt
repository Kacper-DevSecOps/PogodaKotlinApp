package kacper.seiler.pogoda

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI{
    @GET("weather?&appid=197dd7d01b883a898c64730435387df7")
    fun getForecast(@Query("q") qrr: String) : Call<WeatherJSON>
//    fun getForecast() : Call<List<WeatherJSON>>  //for more than one day with correct forecast api

}

 class WeatherJSON(val main: WthMain , val name: String, val timezone : Int)
 class WthMain(val temp: Double, val humidity : Double, val feels_like : Double, val pressure : Double)  //Kelvin

//class  Forecast (val temp: Double, val feels_like: Double )

class WeatherRetriever{

    val service: OpenWeatherAPI


    init{


       val retrofit = Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build()


       // val retrofit = Retrofit.Builder().baseUrl("https://api.openweathermap.org/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(OpenWeatherAPI::class.java)
    }

    fun getForecast(callback: Callback<WeatherJSON>, searchTerm: String){     //Same type as in interface
        val qrr = searchTerm
        val call = service.getForecast(qrr)
        call.enqueue(callback)

    }
}