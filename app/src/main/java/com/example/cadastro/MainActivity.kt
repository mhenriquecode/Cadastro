package com.example.cadastro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etNomeCompleto: EditText
    private lateinit var etTelefone: EditText
    private lateinit var etEmail: EditText
    private lateinit var cbListaEmail: CheckBox
    private lateinit var rgSexo: RadioGroup
    private lateinit var etCidade: EditText
    private lateinit var spUf: Spinner
    private lateinit var btnSalvar: Button
    private lateinit var btnLimpar: Button

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNomeCompleto = findViewById(R.id.editNome)
        etTelefone = findViewById(R.id.editTelefone)
        etEmail = findViewById(R.id.editEmail)
        cbListaEmail = findViewById(R.id.checkListaEmail)
        rgSexo = findViewById(R.id.radioGroupSexo)
        etCidade = findViewById(R.id.editCidade)
        spUf = findViewById(R.id.spinnerUF)
        btnSalvar = findViewById(R.id.btnSalvar)
        btnLimpar = findViewById(R.id.btnLimpar)

        val spinnerUF: Spinner = findViewById(R.id.spinnerUF)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.ufArray,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerUF.adapter = adapter

        btnSalvar.setOnClickListener { salvarFormulario() }
        btnLimpar.setOnClickListener { limparCampos() }

    }
    private fun salvarFormulario() {
        val nome = etNomeCompleto.text.toString().trim()
        val telefoneStr = etTelefone.text.toString().trim()
        val emailStr = etEmail.text.toString().trim()
        val cidadeStr = cbListaEmail.text.toString().trim()
        val ufStr = spUf.selectedItem.toString()
        val listaEmail = cbListaEmail.isChecked

        val sexoId = rgSexo.checkedRadioButtonId
        val sexoStr = if (sexoId != -1) {
            findViewById<RadioButton>(sexoId).text.toString()
        } else ""

        if (nome.isEmpty() || telefoneStr.isEmpty() || emailStr.isEmpty() || cidadeStr.isEmpty() || ufStr == "Selecionar Estado"){
            Toast.makeText(this, "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show()
            return
        }

        val formulario = Formulario(nome, telefoneStr, emailStr, listaEmail, sexoStr, cidadeStr, ufStr)

        Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()

    }

    private fun limparCampos() {
        etNomeCompleto.text?.clear()
        etTelefone.text?.clear()
        etCidade.text?.clear()
        cbListaEmail.isChecked = false
        rgSexo.clearCheck()
        etCidade.text?.clear()
        spUf.setSelection(0)
    }
}