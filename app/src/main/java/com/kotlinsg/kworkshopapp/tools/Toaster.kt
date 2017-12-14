package com.kotlinsg.kworkshopapp.tools

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

interface Toaster {
    fun show(msg: String)
}

class ToasterImpl @Inject constructor(
        val appContext: Context
) : Toaster {
    override fun show(msg: String) {
        Toast.makeText(appContext, "error updating project!", Toast.LENGTH_SHORT).show()
    }
}