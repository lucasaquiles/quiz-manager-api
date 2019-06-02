package com.lucasaquiles.resource

import com.lucasaquiles.domain.Alternative
import com.lucasaquiles.domain.Exam
import com.lucasaquiles.domain.Quiz
import com.lucasaquiles.repository.Repository
import com.lucasaquiles.resource.requestVO.AlternativeRequest
import com.lucasaquiles.resource.requestVO.QuizPostRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.jetbrains.annotations.NotNull
import javax.validation.Valid

@Validated
@Controller("/quiz")
class QuizResource(protected val quizRepository: Repository<Quiz>){


    @Get
    fun get(id: Long): Quiz? = quizRepository.findById(id)

    @Post("/")
    fun save(@Body @Valid quizRequest: QuizPostRequest) : HttpResponse<Quiz>{

        val quiz = Quiz(quizRequest.title ,  quizRequest.minScore, Exam(0, ArrayList()))
        quizRepository.save(quiz)

        return HttpResponse.created(quiz)
    }

    @Post("/quiz/{id}/alternative")
    fun addAlternative(@NotNull id: Long, @Body @Valid alternativePostRequest: AlternativeRequest) : HttpResponse<AlternativeRequest>{

        val quiz = quizRepository.findById(id)
        val alternative = Alternative(alternativePostRequest.alternative, quiz!!, alternativePostRequest.score)

        quiz.alternatives.add(alternative)
        quizRepository.save(quiz)

        return HttpResponse.created(alternativePostRequest)
    }
}