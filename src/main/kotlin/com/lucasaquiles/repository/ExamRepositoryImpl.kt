package com.lucasaquiles.repository

import com.lucasaquiles.domain.Exam

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

open class ExamRepositoryImpl(
        @param: CurrentSession @field: PersistenceContext
        private val entityManager: EntityManager) : Repository<Exam> {

    @Transactional(readOnly = true)
    override fun save(obj: Exam): Exam {

        entityManager.persist(obj);

        return obj;
    }

    override fun findAll(): List<Exam> {

        return entityManager.createQuery("from Exam").resultList as List<Exam>
    }

    override fun findById(id: Long): Exam? {

        return entityManager.find(Exam::class.java, id)

    }


}