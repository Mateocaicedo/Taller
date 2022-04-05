package com.caicedoramirez.taller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var datos: List<Datos>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //var titulos = arrayListOf<String>()
    //var detalles = arrayListOf<String>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var titulo:TextView = itemView.findViewById(R.id.name_task)
        var detalle:TextView = itemView.findViewById(R.id.descripcion_element)
        init {
            itemView.setOnClickListener{
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "Hiciste click en el item Nro ${position+1}", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_element, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val newList = datos[i]
        holder.titulo.text = newList.titulo
        holder.detalle.text = newList.descripcion
    }

    override fun getItemCount(): Int {
        return datos.size
    }


}