package com.lucasaquiles.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
class Exam(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @JsonIgnore
        @OneToMany(mappedBy = "exam")
        val quizes: MutableList<Quiz>,
        val date: Date,
        val validDate: Date,
        val active: Boolean
)