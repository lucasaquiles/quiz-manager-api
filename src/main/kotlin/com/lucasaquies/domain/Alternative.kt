package com.lucasaquiles.domain

import java.math.BigDecimal

class Alternative(
        val id: Long,
        val alternative: String,
        val quiz: Quiz,
        val score: BigDecimal
)