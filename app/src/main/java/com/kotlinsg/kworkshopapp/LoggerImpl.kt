package com.kotlinsg.kworkshopapp

import android.util.Log
import com.github.nekdenis.mylibrary.di.Logger


class LoggerImpl : Logger{
    override fun d(message:String) {
        Log.d("",message)
    }
}