package br.com.felippeneves.kotlin_base_project.data.repository.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://www.themealdb.com/api/json/"
private const val API_VERSION = "v1/1/"

class RetrofitJsonInstance {

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL + API_VERSION)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    fun <API> createService(apiClass: Class<API>): API {
        return retrofit.create(apiClass)
    }
}