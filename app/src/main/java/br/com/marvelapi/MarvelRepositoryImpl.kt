package br.com.marvelapi

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