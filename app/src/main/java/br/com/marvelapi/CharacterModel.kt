package br.com.marvelapi

data class CharacterModel(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)

data class Thumbnail(
    val path: String,
    val extension: String,
)

data class MarvelListResponse(
    val data: MarvelResults
)

data class MarvelResults(
    val results: List<CharacterModel>
)

