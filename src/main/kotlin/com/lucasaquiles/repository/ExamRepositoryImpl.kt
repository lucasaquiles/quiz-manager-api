package com.lucasaquiles.repository

import com.lucasaquiles.domain.Exam

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class ExamRepositoryImpl(
        @param: CurrentSession @field: PersistenceContext
        private val entityManager: EntityManager) : Repository<Exam> {

    @Transactional
    override fun save(obj: Exam): Exam {

        entityManager.persist(obj);

        return obj;
    }

    @Transactional(readOnly = true)
    override fun findAll(): List<Exam> {

        return entityManager.createQuery("select e from Exam e").resultList as List<Exam>
    }

    @Transactional(readOnly= true)
    override fun findById(id: Long): Exam? {

        return entityManager.find(Exam::class.java, id)

    }


}