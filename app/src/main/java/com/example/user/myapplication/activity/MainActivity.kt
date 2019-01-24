package com.example.user.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val observable = Observable.just("hello","world","world1","ashish")

        val observer = getObserver()

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    private fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onComplete() {
                Log.d(TAG,"check_ak complete")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG,"check_ak subscribe")
            }

            override fun onNext(t: String) {
                Log.d(TAG,"check_ak next:"+t)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG,"check_ak error")
            }

        }
    }

    companion object {
        private val TAG = MainActivity::class.qualifiedName
    }
}