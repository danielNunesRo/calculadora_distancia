package com.example.calculadora_distancia

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora_distancia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var valor: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.calculate -> calculate()
        }
    }

    // Método para calcular a distância
    private fun calculate() {
        val inputUnit = binding.mySpinner.selectedItem.toString()
        val outputUnit = binding.requestSpinner.selectedItem.toString()
        val inputValue = valor

        // Realizar a conversão de unidades
        val result = when (inputUnit) {
            "Centímetros" -> {
                when (outputUnit) {
                    "Centímetros" -> inputValue
                    "Metros" -> inputValue / 100
                    "Quilômetros" -> inputValue / 100000
                    "Milhas" -> inputValue / 160934
                    else -> 0.0
                }
            }
            "Metros" -> {
                when (outputUnit) {
                    "Centímetros" -> inputValue * 100
                    "Metros" -> inputValue
                    "Quilômetros" -> inputValue / 1000
                    "Milhas" -> inputValue / 1609
                    else -> 0.0
                }
            }
            "Quilômetros" -> {
                when (outputUnit) {
                    "Centímetros" -> inputValue * 100000
                    "Metros" -> inputValue * 1000
                    "Quilômetros" -> inputValue
                    "Milhas" -> inputValue / 1.609
                    else -> 0.0
                }
            }
            "Milhas" -> {
                when (outputUnit) {
                    "Centímetros" -> inputValue * 160934
                    "Metros" -> inputValue * 1609
                    "Quilômetros" -> inputValue * 1.609
                    "Milhas" -> inputValue
                    else -> 0.0
                }
            }
            else -> 0.0
        }

        // Exibir o resultado no TextView
        binding.resultValue.text = result.toString()
    }
}
