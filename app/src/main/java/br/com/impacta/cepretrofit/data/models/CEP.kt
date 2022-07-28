package br.com.impacta.cepretrofit.data.models

data class CEP(
    val bairro: String,
    val cep: String,
    val cidade: String,
    val cidadeInfo: CidadeInfo,
    val complemento: String?,
    val estado: String,
    val estadoInfo: EstadoInfo,
    val logradouro: String
)