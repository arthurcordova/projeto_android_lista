package com.mobway.minhaprimeiralista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.mobway.minhaprimeiralista.model.Pessoa
import com.mobway.minhaprimeiralista.model.SaveData
import com.mobway.minhaprimeiralista.model.User
import java.text.DecimalFormat

class LoginActivity : AppCompatActivity() {

    lateinit var editTextEmail: EditText
    lateinit var editTextSenha: EditText
    lateinit var buttonLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextSenha = findViewById(R.id.editTextSenha)
        buttonLogin = findViewById(R.id.buttonLogin)


        buttonLogin.setOnClickListener {

            SaveData.user = User(editTextSenha.text.toString(), editTextSenha.text.toString())

            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
        }

        // Lista na forma mais simples
        val listStrings = arrayListOf<String>()
        listStrings.add("macaco")
        listStrings.add("jacare")
        listStrings.add("ovelha")

        // Lista que valida items duplicados
        val setString = mutableSetOf<String>()
        setString.add("macaco")
        setString.add("macaco")
        setString.add("ovelha")

        // Lista que trablha com chave/valor
        val hashMap = hashMapOf<Int, User>()
        hashMap.put(111, User("arthur@gmail.com", "s1287321783"))
        hashMap.put(222, User("joao@gmail.com", "s1287321783"))
        hashMap.put(987, User("maria@gmail.com", "s1287321783"))

        for ((key, value) in hashMap) {

            println("$key -> ${value.email}")

        }


        val hashMapDependents = hashMapOf<Long, MutableSet<String>>()
        hashMapDependents.put(878976786786, mutableSetOf("Arthur", "Arthur", "Maria"))
        hashMapDependents.put(878976786734, mutableSetOf("Jose", "Pedro", "Joaquim"))

        for ((key, value) in hashMapDependents) {
            println("$key -> ")
            value.forEach {
                println("$it")
            }
        }
    }

    fun validarSenha() {
        editTextSenha.text.apply {
            val value = this.toString()
            val isValid = (value.length > 5)
            if (!isValid) {
                editTextSenha.error = "Senha inválida"
            } else {
                editTextSenha.error = null
            }
        }
    }


}