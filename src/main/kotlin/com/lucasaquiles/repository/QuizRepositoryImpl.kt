package com.lucasaquiles.repository

import com.lucasaquiles.domain.Quiz
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class QuizRepositoryImpl(
        @param: CurrentSession @field: PersistenceContext
        private val entityManager: EntityManager) : Repository<Quiz> {

    override fun update(obj: Quiz): Quiz {
       return obj
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): Quiz? {

        return entityManager.find(Quiz::class.java, id)
    }



    @Transactional
    override fun save(obj: Quiz): Quiz {
        entityManager.persist(obj)
        return obj;
    }

    @Transactional(readOnly = true)
    override fun findAll(): List<Quiz> {
        return emptyList();
    }
}