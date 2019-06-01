package com.lucasaquiles.resource

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import java.lang.reflect.Proxy

@Controller("/exam")
class ExamResource{

    @Post("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun index(): ExamResource {

        val examResource = ExamResource()

        return examResource;
    }
}