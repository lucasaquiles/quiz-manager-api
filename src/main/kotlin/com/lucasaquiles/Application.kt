package com.lucasaquiles

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition


@OpenAPIDefinition(
        info = @Info(
                title = "Quiz Manager API",
                version = "0.1",
                description = "sample project using micronaut",
                license = @License(name = "Apache 2.0"),
                contact = @Contact(name = "@lucasaquiles")
        )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.lucasaquiles")
                .mainClass(Application.javaClass)
                .start()
    }
}