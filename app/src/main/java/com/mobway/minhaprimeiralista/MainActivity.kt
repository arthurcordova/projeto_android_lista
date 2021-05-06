package com.mobway.minhaprimeiralista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobway.minhaprimeiralista.model.Pessoa

class MainActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    lateinit var meuArrayDeAnimais: ArrayList<Pessoa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarElementos()
        carregarArray()

        /**
         * Necessário passar um adapter para o RecyclerView trabalhar
         * Adapter é o responsável por manipulação do layout x dados
         */
        recyclerView?.adapter = AdapterRecyclerView(this, meuArrayDeAnimais)

        /**
         * Necessário passar um LayoutManager para o RecyclerView trabalhar
         * LayoutManager é o responsável por dar uma orientação ao scroll e forma que o
         * RecyclerView irá trabalhar (e.x LinearLayoutManager, GridLayoutManager)
         */
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Carrega o elemento RecyclerView da tela para o Kotlin
     */
    fun carregarElementos() {
        recyclerView = findViewById(R.id.rv_produtos)
    }

    /**
     * Carrega o nosso array
     */
    fun carregarArray() {
        meuArrayDeAnimais = ArrayList()
        meuArrayDeAnimais.add(Pessoa("Arthur", 34, R.drawable.ic_android_black_24dp))
        meuArrayDeAnimais.add(Pessoa("Pedro", 2, R.drawable.ic_baseline_flight_24))
        meuArrayDeAnimais.add(Pessoa("Joaquim", 3, R.drawable.ic_baseline_accessibility_24))
    }


}