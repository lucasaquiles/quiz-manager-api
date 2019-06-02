package com.lucasaquiles.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.jetbrains.annotations.NotNull
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
        val alternatives: MutableSet<Alternative>,
        val minScore: BigDecimal,

        @ManyToOne
        val exam: Exam

){
        constructor(title:String,  minScore: BigDecimal, exam:Exam):this(0, title, HashSet(), minScore, exam)

}
