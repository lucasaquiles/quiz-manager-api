package com.lucasaquiles.resource

import com.lucasaquiles.domain.Quiz
import com.lucasaquiles.repository.QuizRepository
import com.lucasaquiles.resource.requestVO.QuizPostRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/quiz")
class QuizResource(protected val quizRepository: QuizRepository){


    @Get
    fun get(id: Long): Quiz? = quizRepository.findById(id)

    @Post("/")
    fun save(@Body @Valid quizRequest: QuizPostRequest) : HttpResponse<Quiz>{

        val quiz = Quiz(0, quizRequest.title, HashSet(), quizRequest.minScore)
        quizRepository.save(quiz)

        return HttpResponse.created(quiz)
    }
}