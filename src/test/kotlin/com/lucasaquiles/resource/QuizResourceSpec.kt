package com.lucasaquiles.resource

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object QuizResourceSpec : Spek({

    describe("suite test for quiz resource"){
        val embeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client = HttpClient.create(embeddedServer.url);

        it("faz alguma coisa"){
            val ids = ArrayList<Long?>();

            
        }


    }

})