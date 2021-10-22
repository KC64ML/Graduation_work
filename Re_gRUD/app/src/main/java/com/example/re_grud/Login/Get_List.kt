package com.example.re_grud.Login

import com.google.gson.annotations.SerializedName


class Get_List(
    @SerializedName("age")
    var age : String,

    @SerializedName("email")
    var email: String,

    @SerializedName("familyname")
    var familyname:String,



    @SerializedName("username")
    var username:String,

    @SerializedName("password")
    var password:String

)