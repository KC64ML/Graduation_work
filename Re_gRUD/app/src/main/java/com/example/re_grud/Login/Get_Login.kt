package com.example.re_grud.Login

import com.google.gson.annotations.SerializedName


class Get_Login (

    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password:String

)