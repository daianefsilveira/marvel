package br.com.marvelapi

import java.io.Serializable

data class MarvelListResponse(
    val data: MarvelResults
)

data class MarvelResults(
    val results: List<CharacterModel>
)

data class CharacterModel(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
) : Serializable

data class Thumbnail(
    val path: String,
    val extension: String
)



