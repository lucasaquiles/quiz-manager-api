package com.lucasaquiles

import io.micronaut.runtime.Micronaut


//@OpenAPIDefinition(
//    info = Info(
//            title = "Quiz Manager API",
//                version = "0.1",
//                description = "sample project using micronaut",
//                license = io.swagger.v3.oas.annotations.info.License(name="Apache 2.0")
//    )
//)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.lucasaquiles")
                .mainClass(Application.javaClass)
                .start()
    }
}