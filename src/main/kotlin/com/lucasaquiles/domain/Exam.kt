package com.lucasaquiles.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Exam(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @JsonIgnore
        @OneToMany(mappedBy = "exam")
        val quizes: List<Quiz>
)