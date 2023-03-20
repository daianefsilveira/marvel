package br.com.marvelapi.data.repositories

import br.com.marvelapi.MarvelListResponse
import br.com.marvelapi.data.remote.MarvelApiService
import retrofit2.Response

class MarvelRepositoryImpl(
    private val marvelApiService: MarvelApiService
): MarvelRepository {

    override suspend fun getCharacterList(): Response<MarvelListResponse> {
        return marvelApiService.getCharacterList()
    }

    override suspend fun getCharacter(id: Int): Response<MarvelListResponse> {
        return marvelApiService.getCharacter(id)
    }
}