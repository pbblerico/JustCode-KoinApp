package com.example.koinapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koinapp.data.network.DogFactResponse
import com.example.koinapp.data.useCases.DogFactsUseCase

class MainViewModel (
    private val getDogFacts: DogFactsUseCase
): BaseViewModel() {

    private var _factsData = MutableLiveData<DogFactResponse>()
    val factsData: LiveData<DogFactResponse> = _factsData


    fun getDogFacts() {
        launch(
            request = {
                getDogFacts.execute()
            },
            onSuccess = {facts ->
                facts?.let {
                    _factsData.postValue(it)
                }
            }
        )
    }
}