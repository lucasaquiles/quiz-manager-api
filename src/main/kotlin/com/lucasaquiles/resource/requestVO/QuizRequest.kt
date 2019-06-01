package com.lucasaquiles.resource.requestVO

import com.lucasaquiles.domain.Alternative
import java.math.BigDecimal
import javax.validation.constraints.NotBlank

data class QuizPostRequest(
        @NotBlank
        val title: String,
        val alternatives: Set<Alternative>,
        @NotBlank
        val minScore: BigDecimal
)

data class QuizUpdateRequest(
        val id: Long,
        val title: String,
        val minScore: BigDecimal
)