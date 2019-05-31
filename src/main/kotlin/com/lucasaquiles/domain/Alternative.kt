package com.lucasaquiles.domain

import java.math.BigDecimal
import javax.persistence.*


@Entity
class Alternative(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val alternative: String,
        @ManyToOne
        val quiz: Quiz,
        val score: BigDecimal
)