package com.example.ht5_3

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

interface ApiInterface {
suspend fun getCats(): List<Cat>
}

class CatService : ApiInterface {

    companion object {
        const val BASE_URL = "https://api.thecatapi.com/v1/images/search?limit=1"
    }

    private val client = HttpClient(CIO)
    private val json = Json { ignoreUnknownKeys = true }
    private var result: MutableList<Cat> = mutableListOf()

    override suspend fun getCats(): List<Cat> = withContext(Dispatchers.IO) {
        val response: HttpResponse = client.get(BASE_URL)

        result = json.decodeFromString(response.body())
        return@withContext result
    }
}