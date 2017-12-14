package com.github.nekdenis.mylibrary

import com.github.nekdenis.mylibrary.di.NetworkClient
import javax.inject.Inject

class NetworkClientImpl @Inject constructor(

) : NetworkClient {
    override fun request(url: String): String = "$url can't be processed"
}