package com.example.facilities_assessment.model

data class FacilitiesResponse(
    val exclusions: ArrayList<ArrayList<Exclusion>>,
    val facilities: ArrayList<Facility>
)

data class Facility(
    val facility_id: String,
    val name: String,
    val options: List<Option>
)

data class Option(
    val icon: String,
    val id: String,
    val name: String
)

data class Exclusion(
    val facility_id: String,
    val options_id: String
)