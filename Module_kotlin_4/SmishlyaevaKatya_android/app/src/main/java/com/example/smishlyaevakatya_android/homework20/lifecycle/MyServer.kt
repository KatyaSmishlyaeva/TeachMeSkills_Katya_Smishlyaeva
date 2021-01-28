package com.example.smishlyaevakatya_android.homework20.lifecycle

import android.util.Log
import androidx.lifecycle.*

class MyServer : LifecycleObserver {
    private val tag = "MyServer"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(tag, "Lifecycle ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun connect() {
        Log.i(tag, "Lifecycle ON_START")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(tag, "Lifecycle ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(tag, "Lifecycle ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun disconnect() {
        Log.i(tag, "Lifecycle ON_STOP")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(tag, "Lifecycle ON_DESTROY")
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun onAny(source: LifecycleOwner?, event: Lifecycle.Event?) {
//        Log.i(tag, "onAny() $source $event")
//    }
}