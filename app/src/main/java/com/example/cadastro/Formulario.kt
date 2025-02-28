package com.example.cadastro

data class Formulario(
    var name: String,
    var phone: String,
    var email: String,
    var listEmail: Boolean,
    var sex: String,
    var city: String,
    var uf: String
)
{
    override fun toString(): String {
        return """
            Nome: $name
            Telefone: $phone
            E-mail: $email
            E-mailListado: $listEmail
            Sexo: $sex
            Cidade: $city
            UF: $uf
        """.trimIndent()
    }
}

