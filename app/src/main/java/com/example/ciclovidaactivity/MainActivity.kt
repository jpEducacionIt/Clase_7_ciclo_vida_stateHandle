package com.example.ciclovidaactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private lateinit var textNumero: TextView
    private lateinit var boton: Button

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("TEST", "onCreate: ")

        textNumero = findViewById(R.id.textViewNumero)
        boton = findViewById(R.id.button)

        textNumero.text = contador.toString()

        boton.setOnClickListener {
            mainViewModel.addNumber()
        }
        mainViewModel.contador.observe(this, Observer {
            textNumero.text = it.toString()
            contador = it
        })
    }

    override fun onStart() {
        super.onStart()
        Log.i("TEST", "onStart: $contador ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("TEST", "onResume: $contador")
    }

    override fun onPause() {
        super.onPause()
        Log.i("TEST", "onPause: $contador")
    }

    override fun onStop() {
        super.onStop()
        Log.i("TEST", "onStop: $contador")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TEST", "onRestart: $contador")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TEST", "onDestroy: $contador")
    }
}
