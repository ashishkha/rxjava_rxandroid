package com.example.user.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.user.myapplication.activity.api.Api.Companion.BASE_URL
import com.example.user.myapplication.activity.builder.RetrofitBuilder
import com.example.user.myapplication.activity.interfaces.ApiInterface
import com.example.user.sampleprojectwithkotlin.login.LoginData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var retrofit: Retrofit = RetrofitBuilder.getApi(BASE_URL)!!
        var apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)
        var observable: Observable<LoginData> = apiInterface.requestLogin("demo007@gmail.com", " Kannan123")
        observable
                ?.subscribeOn(Schedulers.io())//schedulers.io to making network calls //subscribeon tells the observable to start the task on background thread
                ?.observeOn(AndroidSchedulers.mainThread())//to update ui mainthread method // observeon to receive the data on ui thread
                ?.subscribe({ result ->
                    showToastMessage(result.message)
                }, { t ->
                    showToastMessage(t.message)
                })
    }

    private fun showToastMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private val TAG = MainActivity::class.qualifiedName
    }
}