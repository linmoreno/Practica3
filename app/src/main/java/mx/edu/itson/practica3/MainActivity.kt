package mx.edu.itson.practica3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val button = findViewById<Button>(R.id.btn_get_started)

        button.setOnClickListener {
            val intent : Intent=Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}