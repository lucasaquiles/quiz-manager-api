package com.lucasaquiles.domain

import java.math.BigDecimal

class Quiz(

        val id: Long,
        val title: String,
        val alternatives: List<Alternative>,
        val minScore: BigDecimal

)
