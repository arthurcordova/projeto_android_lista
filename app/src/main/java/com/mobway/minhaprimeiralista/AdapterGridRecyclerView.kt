package com.mobway.minhaprimeiralista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mobway.minhaprimeiralista.model.ItemMenu
import com.mobway.minhaprimeiralista.model.Pessoa

class AdapterGridRecyclerView(
    val context: Context,
    val lista: ArrayList<ItemMenu>,
    val onClick: ItemClickListener? = null
) : RecyclerView.Adapter<ViewHolder>() {

    /**
     * Passa neste método para definir qual o layout que vc quer usar em cada item da lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_da_nosso_grid, parent, false)
        return ViewHolder(view, onClick)
    }

    /**
     * Passa neste método para popular cada item da lista
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        lista[position].apply {
            holder.textViewTitulo.text = this.title
            holder.imageViewAvatar.setImageResource(this.image)

        }

    }

    /**
     * Verifica o número de elementos no array
     * Usa este método como base para carregar a sua lista (Para o adapter saber o total de elementos que vai utilizar)
     */
    override fun getItemCount(): Int {
        return lista.size
    }

}

/**
 * View onde serão manipulados os elementos da tela com o Kotlin
 */
class ViewHolder(itemView: View, private val nossaInterface: ItemClickListener?) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    var textViewTitulo: TextView
    var imageViewAvatar: ImageView

    init {
        textViewTitulo = itemView.findViewById(R.id.textView_titulo)
        imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar)

    }

    //
    override fun onClick(v: View?) {
//        nossaInterface?.onClickItem(v, adapterPosition)
    }

    //
    override fun onLongClick(v: View?): Boolean {

        return true
    }

}

