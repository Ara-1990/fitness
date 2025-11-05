package com.the.fitness.data

import com.the.fitness.domain.Repository

import com.the.fitness.domain.All_Exercise



class RepositoryImpl(private val dao: Dao): Repository {

    override suspend fun getAll() = dao.getAll().map { it.toDomain() }
    override suspend fun getBicBrest(week: Int) = dao.getBicBrest(week).map { it.toDomain() }
    override suspend fun getTricBack(week: Int) = dao.getTricepsBack(week).map { it.toDomain() }
    override suspend fun getSholderLegs(week: Int) = dao.getShoulderLegs(week).map { it.toDomain() }

}