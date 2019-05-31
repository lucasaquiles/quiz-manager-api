package com.lucasaquiles.repository

import com.lucasaquiles.domain.Quiz
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.runtime.ApplicationConfiguration
import io.micronaut.spring.tx.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

class QuizRepositoryImpl(
        @param:CurrentSession @field:PersistenceContext
        private val entityManager: EntityManager,
        private val applicationConfiguration: ApplicationConfiguration
) : QuizRepository {

    override fun findById(id: Long): Quiz? {

        return entityManager.find(Quiz::class.java, id)
    }

    @Transactional(readOnly = true)
    override fun save(quiz: Quiz): Quiz {
        entityManager.persist(quiz)
        return quiz;
    }

    @Transactional(readOnly = true)
    override fun findAll(): List<Quiz> {
        return emptyList();
    }


}