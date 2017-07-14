package com.kotlinsg.kworkshopapp

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import java.io.Reader


data class GithubProject(
        val name: String = "",
        val stargazers_count: Int = 0,
        val forks_count: Int = 0
) {

    class Deserializer : ResponseDeserializable<GithubProject> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, GithubProject::class.java)
    }
}