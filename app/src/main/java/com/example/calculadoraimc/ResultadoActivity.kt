package com.example.calculadoraimc

import android.annotation.SuppressLint
import android.os.Bundle

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultadoActivity : AppCompatActivity() {

    private lateinit var textAltura: TextView
    private lateinit var textPeso: TextView
    private lateinit var textResultado: TextView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textAltura = findViewById(R.id.text_altura)
        textPeso = findViewById(R.id.text_peso)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras
        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado: $peso kg"
            textAltura.text = "Altura informada: $altura m"

            val imc = peso / (altura * altura)

            textResultado.text = if (imc < 18.5) {
               "Baixo"

            } else if (imc in 18.9..24.9) {
                "normal"
            } else if (imc in 25.0..29.9){
                "sobrepeso"
            } else {
                "obesidade"
            }
        }

    }
}
