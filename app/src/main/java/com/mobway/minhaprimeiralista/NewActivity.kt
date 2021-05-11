package com.mobway.minhaprimeiralista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NewActivity : AppCompatActivity() {

    var texteViewEmail: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        texteViewEmail = findViewById<TextView>(R.id.textViewEmail)


    }


}