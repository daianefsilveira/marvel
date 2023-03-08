package br.com.marvelapi

data class Thumbnail (
    val path: String,
    val extension: String,
    val img: String = "$path.$extension"
)