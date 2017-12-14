package com.kotlinsg.kworkshopapp

import com.github.nekdenis.modulea.MainRepo
import javax.inject.Inject


interface MainUseCase {
    fun main()
}

class MainUseCaseImpl @Inject constructor(
        val activity: MainActivity,
        val repo: MainRepo
) : MainUseCase {
    override fun main() {
        checkNotNull(activity)
        checkNotNull(repo)
        repo.getData()
    }
}