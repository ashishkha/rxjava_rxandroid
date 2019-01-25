package com.example.user.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {


    private var observable: Observable<String>? = null
    private var observer: Observer<String>? = null
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observable = Observable.just("a", "b", "c", "d", "e")

        observer = getDataFromObserver()

        observable
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(observer!!)

    }

    private fun getDataFromObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(t: String) {
            }

            override fun onError(e: Throwable) {
            }

        }
    }

    companion object {
        private val TAG = MainActivity::class.qualifiedName
    }

    override fun onDestroy() {
        super.onDestroy()

        //if activity gets killed then observer un-subscribed to observable
        disposable?.dispose()
    }
}