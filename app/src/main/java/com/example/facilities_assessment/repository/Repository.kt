package com.example.facilities_assessment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.facilities_assessment.model.FacilitiesResponse
import com.example.facilities_assessment.network.FacilitiesApi

class Repository(private val userService: FacilitiesApi) {
    suspend fun getFacilities(): LiveData<FacilitiesResponse> {
        val data = MutableLiveData<FacilitiesResponse>()
        val response = userService.webService.getFacilitiesAsync().await()
        data.value = response
        return data
    }
}