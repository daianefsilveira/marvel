package br.com.marvelapi

import br.com.marvelapi.Constants.Companion.BASE_URL
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModules = module {

    viewModel {
        MarvelViewModel(
            marvelRepository = get()
        )
    }

    single {
        MarvelRepositoryImpl(
            marvelApiService = get()
        )
    }

    single {
        getRetrofitInstance()
    }
}

fun getRetrofitInstance(): MarvelApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(MarvelApiService::class.java)
}