package com.example.facilities_assessment.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.facilities_assessment.ViewModelFactory
import com.example.facilities_assessment.databinding.FragmentFacilitiesBinding
import com.example.facilities_assessment.network.FacilitiesApi
import com.example.facilities_assessment.network.apiUtils.StateData
import com.example.facilities_assessment.repository.Repository
import com.example.facilities_assessment.viewModel.FacilitiesViewModel

val TAG = "test"

class FragmentFacilities : Fragment() {

    lateinit var binding : FragmentFacilitiesBinding
    lateinit var viewModel: FacilitiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFacilitiesBinding.inflate(inflater, container, false)
        val repo = Repository(FacilitiesApi)
        viewModel = ViewModelProvider(this, ViewModelFactory(repo))[FacilitiesViewModel::class.java]
        getFacilities()
        return binding.root
    }
    private fun getFacilities(){
        viewModel.getFacilities().observe(viewLifecycleOwner) {
            it?.let { stateData ->
                when(stateData.status){
                    StateData.DataStatus.SUCCESS -> {
                        val data = stateData.data
                        Log.d(TAG, "getFacilities: $data")
                    }
                    StateData.DataStatus.LOADING -> {}
                    StateData.DataStatus.ERROR -> {
                        Toast.makeText(context, "${stateData.error?.message}", Toast.LENGTH_LONG).show()
                    }
                    else -> {}
                }
            }

        }
    }
}