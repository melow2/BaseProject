package com.khs.baseproject

import android.content.Context
import androidx.multidex.MultiDexApplication
import timber.log.Timber

class BaseApplication : MultiDexApplication(){
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Timber.plant(Timber.DebugTree())
    }
}