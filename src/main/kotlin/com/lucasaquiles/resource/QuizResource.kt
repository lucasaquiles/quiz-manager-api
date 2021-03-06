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
import java.net.URI
import java.util.*
import javax.validation.Valid
import kotlin.collections.ArrayList

@Validated
@Controller("/quiz")
class QuizResource(protected val quizRepository: Repository<Quiz>){


    @Get("/")
    fun get(id: Long): Quiz? = quizRepository.findById(id)

    @Post("/")
    fun save(@Body @Valid quizRequest: QuizPostRequest) : HttpResponse<Quiz>{

        val exam = Exam(0, ArrayList(), Date(), Date(), true)

        val quiz = quizRepository.save(Quiz(quizRequest.title ,  quizRequest.minScore, exam))

        return HttpResponse.created(quiz).headers{ headers->
            headers.location(URI.create("/quiz/${quiz.id}"))
        }
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