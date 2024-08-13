package joaotuneli56.github.com

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import carreiras.com.github.kotlin_android_lista_de_compras.ItemModel
import carreiras.com.github.kotlin_android_lista_de_compras.ItemsAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Compras"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            val item = ItemModel(editText.text.toString())
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            itemsAdapter.addItem(item)
            editText.text.clear()
        }

    }
}
