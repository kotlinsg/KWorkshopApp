package com.github.nekdenis.modulea

import android.util.Log
import com.github.nekdenis.mylibrary.di.NetworkClient
import javax.inject.Inject

interface MainRepo {
    fun getData(): Unit
}

class MainRepoImpl @Inject constructor(
        val client: NetworkClient
) : MainRepo {
    override fun getData() {
        Log.d("TAG", client.request("sampleurl"))
    }
}