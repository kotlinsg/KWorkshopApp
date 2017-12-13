package com.kotlinsg.kworkshopapp

import javax.inject.Inject


interface MainUseCase {
    fun main()
}

class MainUseCaseImpl @Inject constructor(val activity: MainActivity) : MainUseCase {
    override fun main() {
        checkNotNull(activity)
    }
}