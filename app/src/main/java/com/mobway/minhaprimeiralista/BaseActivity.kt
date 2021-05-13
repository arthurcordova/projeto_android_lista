package com.mobway.minhaprimeiralista

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), DefaultActivity{
}

interface DefaultActivity {

    fun carregarElementos()
    fun carregarEventos()

}