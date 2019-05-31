package com.lucasaquiles.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import javax.persistence.*

@Entity
class Quiz(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val title: String,

        @JsonIgnore
        @OneToMany(mappedBy = "quiz")
        val alternatives: Set<Alternative>,
        val minScore: BigDecimal

)
