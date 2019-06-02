package com.lucasaquiles.resource.requestVO

import java.util.*
import javax.validation.constraints.NotBlank

data class ExamPostRequest(

        @NotBlank val date: Date,
        @NotBlank val validDat: Date,
        @NotBlank val active: Boolean,
        @NotBlank val quizes : Array<QuizPostRequest>
)