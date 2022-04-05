package com.caicedoramirez.taller

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val c:Context, val datos: ArrayList<Datos>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //var titulos = arrayListOf<String>()
    //var detalles = arrayListOf<String>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var titulo:TextView = itemView.findViewById(R.id.name_task)
        var detalle:TextView = itemView.findViewById(R.id.descripcion_element)

        var delete:TextView
        var edit: TextView
        init {
            delete = itemView.findViewById(R.id.delete_element)
            edit=itemView.findViewById(R.id.edit_element)
            delete.setOnClickListener{
                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setMessage("Are you sure delete this task?")
                            .setPositiveButton("NO"){
                                dialog,_->
                                dialog.dismiss()
                            }
                            .setNegativeButton("YES"){
                                dialog,_->
                                datos.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(itemView.context, "Deleted this Task", Toast.LENGTH_SHORT).show()

                                dialog.dismiss()
                            }
                            .create()
                            .show()
                 }
            edit.setOnClickListener{
                val position = datos[adapterPosition]
                val v = LayoutInflater.from(c).inflate(R.layout.activity_agregar, null)
                val t = v.findViewById<EditText>(R.id.nombret)
                val d = v.findViewById<EditText>(R.id.desc)
                        AlertDialog.Builder(c)
                            .setView(v)
                            .setPositiveButton("OK"){
                                    dialog,_->
                                if (t.text.toString().isEmpty() || d.text.toString().isEmpty()){
                                Toast.makeText(itemView.context, "Campos vacios", Toast.LENGTH_SHORT).show()

                                }else{
                                    position.titulo = t.text.toString()
                                    position.descripcion = d.text.toString()
                                    notifyDataSetChanged()
                                    Toast.makeText(itemView.context, "Task is Edited", Toast.LENGTH_SHORT).show()
                                    dialog.dismiss()
                                }
                            }
                            .setNegativeButton("Cancel"){
                                    dialog,_->
                                    dialog.dismiss()
                            }
                            .create()
                            .show()


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