package com.lucasaquiles.resource

import com.lucasaquiles.resource.requestVO.AlternativeRequest
import com.lucasaquiles.resource.requestVO.QuizPostRequest
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal
import kotlin.test.assertEquals

object QuizResourceSpec : Spek({

    describe("suite test for quiz resource"){
        val embeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client = HttpClient.create(embeddedServer.url);

        it("post request"){
            val ids = ArrayList<Long?>();


            val quizPostRequest = QuizPostRequest("teste", HashSet<AlternativeRequest>(), BigDecimal.ZERO)
            var request: HttpRequest<QuizPostRequest> = HttpRequest.POST("/quiz", quizPostRequest)

            val response = client.toBlocking().exchange<QuizPostRequest, Any>(request)

            assertEquals(HttpStatus.CREATED, response.status)
        }


    }

})