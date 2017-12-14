package com.github.nekdenis.mylibrary

import javax.inject.Inject

interface NetworkClient {
    fun request(url: String): String
}

class NetworkClientImpl @Inject constructor(

) : NetworkClient {
    override fun request(url: String): String = "$url can't be processed"
}