package com.github.nekdenis.mylibrary

import com.github.nekdenis.mylibrary.di.Logger
import com.github.nekdenis.mylibrary.di.NetworkClient
import javax.inject.Inject

class NetworkClientImpl @Inject constructor(
        val logger: Logger
) : NetworkClient {
    override fun request(url: String): String {
        logger.d("requesting $url")
        return "$url can't be processed"
    }
}