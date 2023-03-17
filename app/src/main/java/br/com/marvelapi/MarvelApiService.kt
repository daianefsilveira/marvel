package br.com.marvelapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {

    @GET("/v1/public/characters")
    suspend fun getCharacterList(
        @Query("ts") apiKey: String = Constants.ts,
        @Query("apikey") ts: String = Constants.PUBLIC_KEY,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: String = Constants.limit
    ): Response<MarvelListResponse>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacter(
        @Path("characterId") id: Int,
        @Query("ts") apiKey: String = Constants.ts,
        @Query("apikey") ts: String = Constants.PUBLIC_KEY,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: String = Constants.limit
    ): Response<MarvelListResponse>
}