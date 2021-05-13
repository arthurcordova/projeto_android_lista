package com.mobway.minhaprimeiralista

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobway.minhaprimeiralista.model.ItemMenu


class GridListActivity : BaseActivity(), ItemClickListener {

    lateinit var recyclerGrid: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_list)

        carregarElementos()
        carregarEventos()


        val nossaLista = carregarItensMenu()


        AdapterGridRecyclerView(
            this,
            nossaLista,
            this
        ).apply {
            recyclerGrid.adapter = this
            recyclerGrid.layoutManager = GridLayoutManager(this@GridListActivity, 2)
        }

    }

    override fun carregarElementos() {
        recyclerGrid = findViewById(R.id.recyclerGrid)


    }

    override fun carregarEventos() {

    }

    override fun onClickItem(view: View?, index: Int) {
    }

    override fun onLongClickItem(view: View?, index: Int) {
    }

    fun carregarItensMenu(): ArrayList<ItemMenu> {
        val lista = arrayListOf<ItemMenu>()
        lista.add(ItemMenu("Cadastro", R.color.black, R.drawable.ic_android_black_24dp))
        lista.add(ItemMenu("Produtos", R.color.black, R.drawable.ic_android_black_24dp))
        lista.add(ItemMenu("Minha Conta", R.color.black, R.drawable.ic_android_black_24dp))
        lista.add(ItemMenu("Transferencias", R.color.black, R.drawable.ic_android_black_24dp))
        lista.add(ItemMenu("Feed", R.color.black, R.drawable.ic_android_black_24dp))
        lista.add(ItemMenu("Vendas", R.color.black, R.drawable.ic_android_black_24dp))
        return lista
    }

}