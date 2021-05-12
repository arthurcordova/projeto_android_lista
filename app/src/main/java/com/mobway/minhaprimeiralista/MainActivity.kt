package com.mobway.minhaprimeiralista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mobway.minhaprimeiralista.model.Pessoa
import com.mobway.minhaprimeiralista.model.SaveData

class MainActivity : AppCompatActivity(), ItemClickListener {

    var recyclerView: RecyclerView? = null
    var fabButton: View? = null
    var adapter: AdapterRecyclerView? = null
    var editTextFilter: EditText? = null
    var textViewRodape: TextView? = null
    lateinit var nossaLista: ArrayList<String>
    lateinit var listaBase: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarElementos()
        carregarEventos()


        println(SaveData.user?.email)


        carregarArray()

        /**
         * Necessário passar um adapter para o RecyclerView trabalhar
         * Adapter é o responsável por manipulação do layout x dados
         */
        AdapterRecyclerView(this, nossaLista, this).let {
            adapter = it
            recyclerView?.adapter = it
        }

        /**
         * Forma mais fácil de fazer o on click
         *
         * (Não esta sendo usado no momento)
         */
//        val adapter = AdapterFacilRecyclerView(this, meuArrayDeAnimais) {
//            Toast.makeText(this, it.nome, Toast.LENGTH_SHORT).show()
//        }




        /**
         * Necessário passar um LayoutManager para o RecyclerView trabalhar
         * LayoutManager é o responsável por dar uma orientação ao scroll e forma que o
         * RecyclerView irá trabalhar (e.x LinearLayoutManager, GridLayoutManager)
         */
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }


    fun concatenar(resultado: Float) : String{
        return if (resultado > 8.0) "Aprovado: $resultado" else "Resprovado: $resultado"
    }



    fun carregarEventos() {
        fabButton?.setOnClickListener {

            textViewRodape?.text = concatenar( 10.0F)

//            adapter?.update(nossaListaNova)

        }

        editTextFilter?.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println(s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                println(s)
            }

            override fun afterTextChanged(s: Editable?) {

                val stringParaFiltrar = s.toString()
                if (!stringParaFiltrar.isNullOrEmpty() && stringParaFiltrar.length >= 3) {
                    val filterdList = nossaLista.filter {
                        it.contains(stringParaFiltrar, true )
                    }
                    val nossaListaFiltradaArrayList = arrayListOf<String>()

                    // For de forma tradicional
                    for (item in filterdList) {
                        nossaListaFiltradaArrayList.add(item)
                    }

                    nossaListaFiltradaArrayList.clear()

                    // For de forma mais simples
                    filterdList.forEach {
                        nossaListaFiltradaArrayList.add(it)
                    }

                    adapter?.update(nossaListaFiltradaArrayList)
                } else {
                    adapter?.update(listaBase)
                }
            }
        })
    }

    /**
     * Carrega o elemento RecyclerView da tela para o Kotlin
     */
    fun carregarElementos() {
        recyclerView = findViewById(R.id.rv_produtos)
        fabButton = findViewById(R.id.fabAdd)
        editTextFilter = findViewById(R.id.editTextFilter)
        textViewRodape = findViewById(R.id.textViewRodape)
    }

    /**
     * Carrega o nosso array
     */
    fun carregarArray() {
        nossaLista = ArrayList()
        nossaLista.add("Arthur")
        nossaLista.add("Aline")
        nossaLista.add("Joaquim")
        nossaLista.add("Pedro")
        nossaLista.add("Paulo")
        nossaLista.add("João")
        nossaLista.add("Helena")
        nossaLista.add("João")

        listaBase = arrayListOf()
        listaBase.addAll(nossaLista)

//        meuArrayDeAnimais.add(Pessoa("Arthur", 34, R.drawable.ic_android_black_24dp, "M"))
//        meuArrayDeAnimais.add(Pessoa("Pedro", 2, R.drawable.ic_baseline_flight_24, "M"))
//        meuArrayDeAnimais.add(Pessoa("Joaquim", 3, R.drawable.ic_baseline_accessibility_24, "M"))
//        meuArrayDeAnimais.add(Pessoa("Joao", 70, R.drawable.ic_android_black_24dp, "M"))
//        meuArrayDeAnimais.add(Pessoa("Helena", 70, R.drawable.ic_android_black_24dp, "F"))
//        meuArrayDeAnimais.add(Pessoa("Paulo", 70, R.drawable.ic_android_black_24dp, "M"))
    }

    override fun onClickItem(view: View?, index: Int) {
        val intent = Intent(this, DetalhesActivity::class.java)
//        intent.putExtra("parametro_nome", meuArrayDeAnimais[index].nome)
//        intent.putExtra("parametro_objeto", meuArrayDeAnimais[index])
        startActivity(intent)
    }

    override fun onLongClickItem(view: View?, index: Int) {
        adapter?.removeItem(index)

    }


}