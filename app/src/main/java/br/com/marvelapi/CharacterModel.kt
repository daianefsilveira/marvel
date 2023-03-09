package br.com.marvelapi

import java.io.Serializable

data class CharacterModel(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
) : Serializable

