package com.lucasaquiles

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client


@Client("micronaut")
interface TestClient {

    @Get("/test")
    fun test(): String
}

