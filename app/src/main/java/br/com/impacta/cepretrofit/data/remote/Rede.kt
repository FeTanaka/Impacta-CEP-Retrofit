package br.com.impacta.cepretrofit.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rede {
    // Tudo que estiver dentro do companion object vai estar disponível
    // para acesso mesmo sem uma instância (objeto) dessa classe
    companion object {
        fun getRetrofitInstance(url: String): Retrofit {
            return Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build()
        }
    }
}