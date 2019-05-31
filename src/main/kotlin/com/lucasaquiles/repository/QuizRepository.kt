package com.lucasaquiles.repository

import com.lucasaquiles.domain.Quiz
import javax.validation.constraints.NotBlank

interface QuizRepository {

    fun findById(id: Long): Quiz?
    fun save(@NotBlank quiz: Quiz): Quiz
    fun findAll(): List<Quiz>
}