package com.example.user.sampleprojectwithkotlin.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserData {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("role_id")
    @Expose
    var roleId: Int? = null
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("profile_pic")
    @Expose
    var profilePic: Any? = null
    @SerializedName("country_id")
    @Expose
    var countryId: Any? = null
    @SerializedName("gender")
    @Expose
    var gender: String? = null
    @SerializedName("phone_no")
    @Expose
    var phoneNo: String? = null
    @SerializedName("dob")
    @Expose
    var dob: Any? = null
    @SerializedName("is_active")
    @Expose
    var isActive: Boolean? = null
    @SerializedName("created")
    @Expose
    var created: String? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null

    var userLoggedInSuccessOrFailureMsg: String? = null
}
