package com.lucasaquiles.domain

import java.util.*
import javax.persistence.*

@Entity
class Answer(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        @ManyToOne
        val alternative: Alternative,
        val user: Long,
        @Temporal(TemporalType.TIMESTAMP)
        val date_answer: Date
)