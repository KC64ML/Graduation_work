package image11.graduation.ok.com

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService
{


    @POST("/user/")
    fun requestLogin(@Body project:signup_data):Call<signup_data>


}