package com.example.todo_app

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var etTitulo: EditText
    lateinit var btnGuardar: Button
    lateinit var listaElementos: ListView
    private val tareasViewModel:TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var elementos = mutableListOf<String>()
        tareasViewModel.elementos.add("Hola")
        tareasViewModel.elementos.add("Niggas")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,elementos)

        listaElementos.adapter = adapter
        btnGuardar.setOnClickListener{
        }
        val contenido = etTitulo.text.toString()
        elementos.add(contenido)
        adapter.notifyDataSetChanged()
        Toast.makeText(this, "${elementos.size}",Toast.LENGTH_SHORT).show()

        val titleEditText = findViewById<EditText>(R.id.titleEditText)
        val descriptionEditText = findViewById<EditText>(R.id.descriptionEditText)
        val logButton = findViewById<Button>(R.id.logButton)
        val listView = findViewById<ListView>(R.id.listView)

        val listItems = ArrayList<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        logButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()

            Log.d("MainActivity", "- $title, : $description")

            listItems.add("- $title, : $description")
            adapter.notifyDataSetChanged()
        }
    }
}