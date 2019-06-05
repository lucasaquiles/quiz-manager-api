package com.lucasaquiles.repository

import javax.validation.constraints.NotBlank

interface Repository<T> {

    fun findById(id: Long): T?
    fun save(@NotBlank obj: T): T
    fun update(@NotBlank obj: T): T
    fun findAll(): List<T>
}