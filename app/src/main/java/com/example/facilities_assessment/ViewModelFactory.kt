package com.example.facilities_assessment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.facilities_assessment.repository.Repository
import com.example.facilities_assessment.viewModel.FacilitiesViewModel

class ViewModelFactory(private val repo: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FacilitiesViewModel(repo) as T
    }
}