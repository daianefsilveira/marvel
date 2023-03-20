package br.com.marvelapi

import br.com.marvelapi.utils.Constants.Companion.BASE_URL
import br.com.marvelapi.data.remote.MarvelApiService
import br.com.marvelapi.data.repositories.MarvelRepository
import br.com.marvelapi.data.repositories.MarvelRepositoryImpl
import br.com.marvelapi.ui.viewmodel.MarvelListViewModel
import br.com.marvelapi.ui.viewmodel.MarvelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModules = module {

    viewModel {
        MarvelListViewModel(
            marvelRepository = get()
        )
    }

    viewModel {
        MarvelViewModel(
            marvelRepository = get()
        )
    }

    factory<MarvelRepository> {
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