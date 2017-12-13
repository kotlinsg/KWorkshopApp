package com.github.nekdenis.modulea

import android.util.Log
import javax.inject.Inject

interface MainRepo
class MainRepoImpl @Inject constructor(

) : MainRepo {
    fun getData() {
        Log.d("TAG", "getData")
    }
}