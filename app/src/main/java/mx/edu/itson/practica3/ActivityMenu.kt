package mx.edu.itson.practica3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent
import mx.edu.itson.practica3.ProductosActivity
import mx.edu.itson.practica3.R




class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        enableEdgeToEdge()
        supportActionBar?.hide()

        var Antojitos: Button = findViewById(R.id.button_Antojitos) as Button
        var Especialidades: Button = findViewById(R.id.button_Especialidades) as Button
        var Combinations: Button = findViewById(R.id.button_combinations) as Button
        var Tortas: Button = findViewById(R.id.button_Tortas) as Button
        var Sopas: Button = findViewById(R.id.button_Sopas) as Button
        var Drinks: Button = findViewById(R.id.button_Drinks) as Button


        Antojitos.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType","Antojitos")
            startActivity(intent)
        }

        Especialidades.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType","Especialidades")
            startActivity(intent)

        }
        Combinations.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType","Combinations")
            startActivity(intent)
        }
        Tortas.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType","Tortas")
            startActivity(intent)
        }
        Sopas.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType","Sopas")
            startActivity(intent)
        }
        Drinks.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType","Drinks")
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}