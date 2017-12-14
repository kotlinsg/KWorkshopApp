package com.github.nekdenis.modulea

import com.github.nekdenis.mylibrary.di.Logger
import com.github.nekdenis.mylibrary.di.NetworkClient
import javax.inject.Inject

interface MainRepo {
    fun getData(): Unit
}

class MainRepoImpl @Inject constructor(
        val client: NetworkClient,
        val logger: Logger
) : MainRepo {
    override fun getData() {
        logger.d(client.request("sampleurl"))
    }
}