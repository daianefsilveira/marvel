package br.com.marvelapi

import retrofit2.Response

interface MarvelRepository {

    suspend fun getCharacterList(): Response<MarvelListResponse>
    suspend fun getCharacter(id: Int): Response<MarvelListResponse>
}