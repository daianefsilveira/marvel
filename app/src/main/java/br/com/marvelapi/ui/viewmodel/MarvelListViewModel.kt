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

class MarvelListViewModel(
    private val marvelRepository: MarvelRepository
) : ViewModel() {

    private var _characterList = MutableLiveData<NetworkResult<MarvelListResponse>>()
    var characterList: LiveData<NetworkResult<MarvelListResponse>> = _characterList

    fun getCharacterList() {
        viewModelScope.launch {
            _characterList.postValue(NetworkResult.Loading())
            val resultList = marvelRepository.getCharacterList()
            _characterList.postValue(handleResponse(resultList))
        }
    }

    private fun handleResponse(resultList: Response<MarvelListResponse>): NetworkResult<MarvelListResponse> {
        if (resultList.isSuccessful) {
            resultList.body().let { values ->
                return NetworkResult.Success(values)
            }
        }
        return NetworkResult.Error(resultList.message())
    }
}

