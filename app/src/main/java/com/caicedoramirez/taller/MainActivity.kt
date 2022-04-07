package com.caicedoramirez.taller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var addBTn: FloatingActionButton
    private lateinit var recv:RecyclerView
    private lateinit var datos:ArrayList<Datos>
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addBTn=findViewById(R.id.btnadd)
        recv = findViewById(R.id.listareciclada)
        datos= ArrayList()
        customAdapter = CustomAdapter(this,datos)
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = customAdapter
        addBTn.setOnClickListener {
            agregarLista()
        }
    }
    private fun agregarLista(){
        val inflter = LayoutInflater.from(this)

        val v= inflter.inflate(R.layout.activity_agregar, null)
        val titulo = v.findViewById<EditText>(R.id.nombret)
        val desc = v.findViewById<EditText>(R.id.desc)
        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
            dialog,_->
            val names = titulo.text.toString()
            val descrip = desc.text.toString()
            if (names.isEmpty() || descrip.isEmpty()){
                Toast.makeText(this,"Campos vacios", Toast.LENGTH_SHORT).show()
            }else{
                datos.add(Datos(names, descrip))
                customAdapter.notifyDataSetChanged()
                Toast.makeText(this,"Adding Task", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel", Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()


    }







}