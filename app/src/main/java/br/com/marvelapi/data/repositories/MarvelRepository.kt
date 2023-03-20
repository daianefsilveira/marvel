package br.com.marvelapi.data.repositories

import br.com.marvelapi.MarvelListResponse
import retrofit2.Response

interface MarvelRepository {

    suspend fun getCharacterList(): Response<MarvelListResponse>
    suspend fun getCharacter(id: Int): Response<MarvelListResponse>
}