package com.lucasaquiles

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition


@OpenAPIDefinition
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.lucasaquiles")
                .mainClass(Application.javaClass)
                .start()
    }
}