package com.lucasaquiles.repository

import com.lucasaquiles.domain.Quiz
import javax.validation.constraints.NotBlank

interface Repository<T> {

    fun findById(id: Long): T?
    fun save(@NotBlank obj: T): T
    fun findAll(): List<T>
}