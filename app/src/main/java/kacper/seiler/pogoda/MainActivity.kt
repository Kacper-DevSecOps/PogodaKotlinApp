package kacper.seiler.pogoda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

//Icons made by <a href="https://www.flaticon.com/authors/bqlqn" title="bqlqn">bqlqn</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>
//<div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var wyszukajMiastoPogoda = findViewById<Button>(R.id.wyszukajBTN)
        wyszukajMiastoPogoda.setOnClickListener {

            //var listaPogodyMove = Intent(getApplicationContext(), listaPogoda::class.java)
            var listaPogodyMove = Intent(this, listaPogoda::class.java) //this used in this class
            val editTxtSearch = findViewById<EditText>(R.id.editTxtSearch)
            listaPogodyMove.putExtra("searchTerm", editTxtSearch.text.toString())


            startActivity(listaPogodyMove)







        }
    }
}