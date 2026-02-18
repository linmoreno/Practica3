package mx.edu.itson.practica3

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView


class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        supportActionBar?.hide()

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductor(menuOption)
        var listview: ListView = findViewById(R.id.litview) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador

    }

    fun agregarProductor(Option: String?) {
        when(Option){
            "Drinks" ->{
                menu.add(Product("Jarritos", R.drawable.jarritos, " Sodas de jarritos de todos los sabores",2.75))
                menu.add(Product("Sodas", R.drawable.sodas, " Sodas de todos los sabores",2.99))
                menu.add(Product("Caguama", R.drawable.caguama, "Caguama ballena",3.99))
                menu.add(Product("Caguama-Michelada", R.drawable.caguamamichelada, "Caguama de michelada",5.99))
                menu.add(Product("Cervesas", R.drawable.domesticbeer, "Todo tipos de cerveza",5.75))
            }

            "Especialidades" ->{
                menu.add(Product("Quesadillas de Fajitas", R.drawable.fajitaquesadilla, " Cinco tacos ", 6.29))
                menu.add(Product("Burritos ", R.drawable.burritos, " Cinco tacos ", 6.29))
            }
            "Combinations" ->{
                menu.add(Product("Cinco Tacos", R.drawable.cinco, " Cinco tacos ", 6.29))
                menu.add(Product("Charolazo", R.drawable.charolazo, "Charola con 5 Chelas", 24.49))
                menu.add(Product("Los Portales Burritos", R.drawable.burritosportales, "Large flour tortilla filled with grilled cactus, steak, pastor (seasoned pork), grilled onions, rice and beans. Served with a side of lettuce salad, tomatoes, sour cream and guacamole.", 14.59))

            }
            "Tortas" ->{
                menu.add(Product("Torta", R.drawable.torta, "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.", 13.39))
                menu.add(Product("Torta Mixta", R.drawable.tortamixta, "Chorizo, asada y pastor. Mexican sausage, steak and marinated pork." , 13.99))
                menu.add(Product("Torta Milanesa", R.drawable.tortamilanesa, "Breaded Stake served with lettuce, sour cream, and guacamole", 13.99))
                menu.add(Product("Torta Cubana", R.drawable.tortacubana, "Chorizo, asada, jamon, pastor y queso. Mexican sausage, steak, marinated pork, ham, and cheese.", 14.49))

            }
            "Sopas" ->{
                menu.add(Product("Pozole", R.drawable.pozole, " Cinco tacos ", 6.29))
                menu.add(Product("Caldo de camaron", R.drawable.caldocamaron, " Cinco tacos ", 6.29))
                menu.add(Product("Menudo", R.drawable.menudo, " Cinco tacos ", 6.29))
                menu.add(Product("Sopa de Mariscos", R.drawable.sopamariscos, " Cinco tacos ", 6.29))

            }
            "Antojitos" ->{
                menu.add(Product("Cinco Tacos", R.drawable.cinco, " Cinco tacos ", 6.29))
                menu.add(Product("coctel", R.drawable.coctel, " Cinco tacos ", 6.29))

            }

        }


    }

    private class AdaptadorProductos : BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any? {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen =vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}