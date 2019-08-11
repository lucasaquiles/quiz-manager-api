package com.lucasaquiles.resource

import com.lucasaquiles.domain.Exam
import com.lucasaquiles.domain.Quiz
import com.lucasaquiles.repository.ExamRepositoryImpl
import com.lucasaquiles.repository.QuizRepositoryImpl
import com.lucasaquiles.resource.requestVO.ExamPostRequest
import com.lucasaquiles.resource.requestVO.QuizPostRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import org.jetbrains.annotations.NotNull
import java.net.URI
import javax.validation.Valid


@Validated
@Controller("/exam")
class ExamResoure (protected val examRepository: ExamRepositoryImpl, protected val quizRepositoryImpl: QuizRepositoryImpl) {


    @Get("/")
    fun index():HttpResponse<List<Exam>>{

        return HttpResponse.created(examRepository.findAll())
    }

    @Get("/{id}")
    fun getById(@NotNull id:Long):HttpResponse<ExamPostRequest>{

        val exam = examRepository.findById(id)

        val examPostRequest = ExamPostRequest(exam!!.endEt, exam!!.startAt, exam!!.active, emptyArray())

        return HttpResponse.created(examPostRequest)
    }

    @Post("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun save(@Body exam:ExamPostRequest) : HttpResponse<Exam>{

        val examObj = Exam(0, ArrayList(), exam.date, exam.validDat, exam.active)

        val saved = examRepository.save(examObj)

        return HttpResponse.created(examObj).headers { headers->
            headers.location(URI.create("/exam/${saved.id}"))
        }
    }

    @Post("/{id}/quiz")
    @Produces(MediaType.APPLICATION_JSON)
    fun addAlternative(@NotNull id: Long, @Body @Valid quizRequest: QuizPostRequest) : HttpResponse<Quiz> {

        val exam = examRepository.findById(id)
        val quiz = Quiz(quizRequest.title, quizRequest.minScore, exam!!)

        quizRepositoryImpl.update(quiz)

        return HttpResponse.created(quiz).headers{headers->
            headers.location(URI.create("/quiz/${quiz.id}"))
        }
    }
}