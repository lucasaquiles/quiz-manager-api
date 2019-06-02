package com.lucasaquiles.resource

import com.lucasaquiles.domain.Exam
import com.lucasaquiles.domain.Quiz
import com.lucasaquiles.repository.ExamRepositoryImpl
import com.lucasaquiles.resource.requestVO.ExamPostRequest
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
@Controller("/exam")
class ExamResoure (protected val examRepository: ExamRepositoryImpl) {


    @Get("/")
    fun index():HttpResponse<List<Exam>>{

        return HttpResponse.created(examRepository.findAll())
    }

    @Get("/{id}")
    fun getById(@NotNull id:Long):HttpResponse<ExamPostRequest>{

        val exam = examRepository.findById(id)

        val examPostRequest = ExamPostRequest(exam!!.date, exam!!.validDate, exam!!.active, exam!!.quizes as Array<QuizPostRequest>)

        return HttpResponse.created(examPostRequest)
    }

    @Post("/")
    fun save(@Body exam:ExamPostRequest) : ExamPostRequest{

        val examObj = Exam(0, ArrayList(), exam.date, exam.validDat, exam.active)

        examRepository.save(examObj);

        return exam;
    }

    @Post("/exam/{id}/quiz")
    fun addAlternative(@NotNull id: Long, @Body @Valid quizRequest: QuizPostRequest) : HttpResponse<QuizPostRequest> {

        val exam = examRepository.findById(id)
        val quiz = Quiz(quizRequest.title, quizRequest.minScore, exam!!)

        exam.quizes.add(quiz)

        examRepository.save(exam)

        return HttpResponse.created(quizRequest)
    }
}