package com.mobway.minhaprimeiralista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobway.minhaprimeiralista.model.Pessoa

class AdapterRecyclerView(
    val context: Context,
    val nossaListaDePessoas: ArrayList<Pessoa>

) : RecyclerView.Adapter<ViewHolderPessoas>() {

    /**
     * Passa neste método para definir qual o layout que vc quer usar em cada item da lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPessoas {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_da_nossa_lista, parent, false)
        return ViewHolderPessoas(view)
    }

    /**
     * Passa neste método para popular cada item da lista
     */
    override fun onBindViewHolder(holder: ViewHolderPessoas, position: Int) {
        nossaListaDePessoas[position].also {
            holder.textViewTitulo.text = it.nome
            holder.textViewSubtitulo.text = "Idade: ${it.idade}"
            holder.imageViewAvatar.setImageResource(it.photo)
        }
    }

    /**
     * Verifica o número de elementos no array
     * Usa este método como base para carregar a sua lista (Para o adapter saber o total de elementos que vai utilizar)
     */
    override fun getItemCount(): Int {
        return nossaListaDePessoas.size
    }
}

/**
 * View onde serão manipulados os elementos da tela com o Kotlin
 */
class ViewHolderPessoas(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var textViewTitulo: TextView
    var textViewSubtitulo: TextView
    var imageViewAvatar: ImageView

    init {
        textViewTitulo = itemView.findViewById(R.id.textView_titulo)
        textViewSubtitulo = itemView.findViewById(R.id.textView_subtitulo)
        imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar)
    }

}