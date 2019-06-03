package com.lucasaquiles.resource

import com.lucasaquiles.repository.ExamRepositoryImpl
import com.lucasaquiles.resource.requestVO.AlternativeRequest
import com.lucasaquiles.resource.requestVO.ExamPostRequest
import com.lucasaquiles.resource.requestVO.QuizPostRequest
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.test.assertEquals


class ExamResourceSpec : Spek( {

    describe("suite test for quiz resource"){

        val embeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client = HttpClient.create(embeddedServer.url)

        it("create new exam"){

            val examPostRequest = ExamPostRequest(Date(), Date(), true, quizes = emptyArray())

            var request: HttpRequest<ExamPostRequest> = HttpRequest.POST("/exam", examPostRequest)

            val response = client.toBlocking().exchange<ExamPostRequest, Any>(request)

            assertEquals(HttpStatus.CREATED, response.status)
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }

})