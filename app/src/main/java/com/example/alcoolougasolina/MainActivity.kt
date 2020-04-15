package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View) {
        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()
        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        if (validaCampos) {
            text_resultado.setText(calcularMelhorPreco(precoAlcool, precoGasolina))
        } else {
            text_resultado.setText("Favor preencher os preços primeiro !!!")
        }

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")) {
            camposValidados = false
        }

        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String): String {
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /**
         * Verificar se compensa alcool ou gasolina
         * (precoAlcool / precoGasolina)
         * se resultado >= 0.7 então compensa gasolina
         * senão compensa alcool
         */

        val resultado = valorAlcool / valorGasolina

        if (resultado >= 0.7) {
            return "Melhor abastecer com Gasolina"
        }
        else {
            return "Melhor abastecer com Álcool"
        }
    }
}
