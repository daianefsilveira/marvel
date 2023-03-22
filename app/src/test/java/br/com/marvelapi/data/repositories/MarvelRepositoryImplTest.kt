package br.com.marvelapi.data.repositories

import br.com.marvelapi.data.remote.MarvelApiService
import br.com.marvelapi.data.CharacterFactory
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class MarvelRepositoryTest {

    private val apiService = mockk<MarvelApiService>()

    private val marvelRepository = MarvelRepositoryImpl(apiService)

    @Test
    fun`WHEN getCharacterList is called THEN return correct result`() = runBlocking {
        //GIVEN
        coEvery { apiService.getCharacterList() } returns Response.success(
            CharacterFactory.characters
        )
        //WHEN
        val result = marvelRepository.getCharacterList()
        //THEN
        Assert.assertEquals(CharacterFactory.characters, result.body())
        coVerify(exactly = 1) { apiService.getCharacterList() }
    }

    @Test
    fun`WHEN getCharacter is called THEN return correct result`() = runBlocking {
        //GIVEN
        coEvery { apiService.getCharacter(id = any()) } returns Response.success(
            CharacterFactory.character
        )
        //WHEN
        val result = marvelRepository.getCharacter(123)
        //THEN
        Assert.assertEquals(CharacterFactory.character, result.body())
        coVerify(exactly = 1) { apiService.getCharacter(123) }
    }
}
