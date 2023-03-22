package br.com.marvelapi.data

import br.com.marvelapi.CharacterModel
import br.com.marvelapi.MarvelListResponse
import br.com.marvelapi.MarvelResults
import br.com.marvelapi.Thumbnail

object CharacterFactory {

    val characters = MarvelListResponse(
        MarvelResults(
            listOf(
                CharacterModel(
                    1234,
                    "Homem Aranha",
                    "Content description, content description, content description",
                    Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9785", "jpg")
                ),
                CharacterModel(
                    5678,
                    "Hulk",
                    "Content description, content description, content description",
                    Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9786", "jpg")
                ),
                CharacterModel(
                    9101,
                    "Homem de Ferro",
                    "Content description, content description, content description",
                    Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9787", "jpg")
                ),
                CharacterModel(
                    1213,
                    "Capitão América",
                    "Content description, content description, content description",
                    Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9788", "jpg")
                ),
            )
        )
    )

    val character = MarvelListResponse(
        MarvelResults(
            listOf(
            CharacterModel(
        1234,
        "Homem Aranha",
        "Content description, content description, content description",
        Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9785", "jpg")
    ))))
}