package com.lucasaquiles

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.lucasaquiles")
                .mainClass(Application.javaClass)
                .start()
    }
}