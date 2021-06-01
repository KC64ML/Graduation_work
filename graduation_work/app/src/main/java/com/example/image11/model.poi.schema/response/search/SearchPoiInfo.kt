package com.example.image11.model.poi.schema.response.search

import com.example.image11.model.poi.schema.response.search.Pois

data class SearchPoiInfo(
    val totalCount: String,
    val count: String,
    val page: String,
    val pois: Pois
)
