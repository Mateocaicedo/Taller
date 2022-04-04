package com.caicedoramirez.taller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Agregar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)


        val btncancelar = findViewById<Button>(R.id.cancelar)

        btncancelar.setOnClickListener{
            finish()
        }

        val nombreTarea = findViewById<EditText>(R.id.nombret)
        val descr =  findViewById<EditText>(R.id.desc)
        val btnagg =  findViewById<Button>(R.id.agg)
        btnagg.setOnClickListener{
            if (nombreTarea.text.toString().length == 0 || descr.text.toString().length ==0){
                Toast.makeText(this, "Los campos no pueden estar vacia", Toast.LENGTH_LONG).show()
            }else{
                println("aaaaaa")
            }
        }



    }
}