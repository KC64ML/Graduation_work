package com.example.image11.model.poi.schema.entity

import android.os.Parcelable
import com.example.image11.model.poi.schema.entity.LocationLatLngEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResultEntity(
    val fullAdress: String,
    val name: String,
    val locationLatLng: LocationLatLngEntity
): Parcelable
