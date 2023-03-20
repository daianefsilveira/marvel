package br.com.marvelapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.marvelapi.MarvelListResponse
import br.com.marvelapi.data.repositories.MarvelRepository
import br.com.marvelapi.utils.NetworkResult
import kotlinx.coroutines.launch
import retrofit2.Response

class MarvelViewModel(
    private val marvelRepository: MarvelRepository
) : ViewModel() {

    private var _character = MutableLiveData<NetworkResult<MarvelListResponse>>()
    var character: LiveData<NetworkResult<MarvelListResponse>> = _character

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            val result = marvelRepository.getCharacter(id)
            _character.postValue(handleResponse(result))
        }
    }

    private fun handleResponse(result: Response<MarvelListResponse>): NetworkResult<MarvelListResponse> {
        if (result.isSuccessful) {
            result.body().let { values ->
                return NetworkResult.Success(values)
            }
        }
        return NetworkResult.Error(result.message())
    }
}


