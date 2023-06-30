package com.example.facilities_assessment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.facilities_assessment.R
import com.example.facilities_assessment.databinding.FragmentFacilitiesBinding

class FragmentFacilities : Fragment() {

    lateinit var binding : FragmentFacilitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFacilitiesBinding.inflate(inflater, container, false)
        return binding.root
    }
}