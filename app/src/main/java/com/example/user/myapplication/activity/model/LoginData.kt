package com.example.user.sampleprojectwithkotlin.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginData {

    @SerializedName("status")
    @Expose
    var status: Int? = null
    @SerializedName("data")
    @Expose
    var data: UserData? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("user_msg")
    @Expose
    var userMsg: String? = null
}
