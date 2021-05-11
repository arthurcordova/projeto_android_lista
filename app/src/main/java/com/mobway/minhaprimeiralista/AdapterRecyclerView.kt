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
import com.mobway.minhaprimeiralista.model.Pessoa

class AdapterRecyclerView(
    val context: Context,
    val nossaListaDePessoas: ArrayList<String>,
    val onClick: ItemClickListener? = null
) : RecyclerView.Adapter<ViewHolderPessoas>() {

    /**
     * Passa neste método para definir qual o layout que vc quer usar em cada item da lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPessoas {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_da_nossa_lista, parent, false)
        return ViewHolderPessoas(view, onClick)
    }

    /**
     * Passa neste método para popular cada item da lista
     */
    override fun onBindViewHolder(holder: ViewHolderPessoas, position: Int) {
        nossaListaDePessoas[position].also {
            holder.textViewTitulo.text = it
            holder.textViewSubtitulo.text = it//"Idade: ${it.idade} Sexo: ${it.sexo}"
//            holder.imageViewAvatar.setImageResource(it.photo)
        }
    }

    /**
     * Verifica o número de elementos no array
     * Usa este método como base para carregar a sua lista (Para o adapter saber o total de elementos que vai utilizar)
     */
    override fun getItemCount(): Int {
        return nossaListaDePessoas.size
    }

    fun addItem(newStr: String) {
        nossaListaDePessoas.add(newStr)
        notifyList()
    }

    fun removeItem(index: Int) {
        nossaListaDePessoas.removeAt(index)
        notifyList()
    }

    fun update(listaFiltrada: ArrayList<String>) {
        nossaListaDePessoas.clear()
        nossaListaDePessoas.addAll(listaFiltrada)
        notifyList()
    }

    private fun notifyList() {
        notifyDataSetChanged()
    }
}

/**
 * View onde serão manipulados os elementos da tela com o Kotlin
 */
class ViewHolderPessoas(itemView: View, private val nossaInterface: ItemClickListener?) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    var textViewTitulo: TextView
    var textViewSubtitulo: TextView
    var imageViewAvatar: ImageView
    var barOptions: View
    var buttonDelete: Button

    init {
        textViewTitulo = itemView.findViewById(R.id.textView_titulo)
        textViewSubtitulo = itemView.findViewById(R.id.textView_subtitulo)
        imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar)
        barOptions = itemView.findViewById(R.id.barOptions)
        buttonDelete = itemView.findViewById(R.id.buttonDelete)

        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)

        buttonDelete.setOnClickListener {
            nossaInterface?.onLongClickItem(it, adapterPosition)
        }
    }

    override fun onClick(v: View?) {
        nossaInterface?.onClickItem(v, adapterPosition)
    }

    override fun onLongClick(v: View?): Boolean {
        if (barOptions.visibility == View.VISIBLE) {
            barOptions.visibility = View.INVISIBLE
        } else if (barOptions.visibility == View.INVISIBLE) {
            barOptions.visibility = View.VISIBLE
        }
        return true
    }

}

interface ItemClickListener {

    fun onClickItem(view: View?, index: Int)
    fun onLongClickItem(view: View?, index: Int)

}


