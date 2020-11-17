package kacper.seiler.pogoda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class listaPogoda : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pogoda)
    //List view that will list the forecast



        var pogodaListaPodlgad = findViewById<ListView>(R.id.PogodaListView)

        var retriver = WeatherRetriever()

        val callback = object : Callback<WeatherJSON>{


            override fun onFailure(call: Call<WeatherJSON>, t: Throwable) {
                               }

                 override fun onResponse(call: Call<WeatherJSON>, response: Response<WeatherJSON>) {
                println("Working")
                println(response.body()?.main?.temp!!.toInt() - 273 )
                     title = response.body()?.name // non standard characters will blank this

                     var temp: String = "Temperatura: " + (((response.body()?.main?.temp!!- 273.15).toInt())).toString() + " °C"
                     var feelTemp: String = "Odczuwalna temperatura: " + ((response.body()?.main?.feels_like!!- 273.15).toInt()).toString() + " °C"
                     var humid = "Wilgotność: " + (response.body()?.main?.humidity!!.toInt()).toString() + "%"
                     var pressur = "Cisnienie: " + (response.body()?.main?.pressure!!.toInt()).toString() + "hPa"
                     var timezoneDiv = "Strefa czasowa: " + (response.body()?.timezone!! / 3600).toString()



                     var endList = listOf(temp, feelTemp,  humid, pressur, timezoneDiv )
                     var adapter = ArrayAdapter(this@listaPogoda, android.R.layout.simple_list_item_1, endList)
                     pogodaListaPodlgad.adapter = adapter
                 }


        }
        var searchTerm = intent.extras.getString("searchTerm")!!
        if (searchTerm == ""){
            searchTerm = "Wrocław"
        }
        retriver.getForecast(callback, searchTerm)

    }


    }
