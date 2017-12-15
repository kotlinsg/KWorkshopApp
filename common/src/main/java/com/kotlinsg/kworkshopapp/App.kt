package com.kotlinsg.kworkshopapp

import android.app.Activity
import android.content.Context


interface App {
    fun inject(activity: Activity)
    fun getApplicationContext(): Context
}