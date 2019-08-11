package com.lucasaquiles.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
class Exam(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @JsonIgnore
        @OneToMany(mappedBy = "exam", fetch = FetchType.EAGER)
        val quizes: MutableList<Quiz>,
        val endEt: Date,
        val startAt: Date,
        val active: Boolean
)