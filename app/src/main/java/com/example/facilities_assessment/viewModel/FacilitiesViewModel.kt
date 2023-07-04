package com.example.facilities_assessment.viewModel

import androidx.lifecycle.ViewModel
import com.example.facilities_assessment.model.FacilitiesResponse
import com.example.facilities_assessment.network.apiUtils.StateLiveData
import com.example.facilities_assessment.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FacilitiesViewModel(private val repository: Repository) : ViewModel() {

    lateinit var viewModelJob: Job

    fun getFacilities(): StateLiveData<FacilitiesResponse> {
        val data = StateLiveData<FacilitiesResponse>()
        data.postLoading()
        viewModelJob = CoroutineScope(Job() + Dispatchers.Main).launch {
            try {
                val response = repository.getFacilities()
                response.value?.let { data.postSuccess(it) }
            } catch (e: Exception) {
                print(e.message)
            }
        }
        return data
    }
}