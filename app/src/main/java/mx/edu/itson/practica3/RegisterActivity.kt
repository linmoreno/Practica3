package mx.edu.itson.practica3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        val button = findViewById<Button>(R.id.btn_sign_in)

        button.setOnClickListener {
            val intent : Intent=Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}