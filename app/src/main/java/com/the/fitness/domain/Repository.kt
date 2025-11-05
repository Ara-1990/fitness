package com.the.fitness.domain

interface Repository {


    suspend fun getAll(): List<All_Exercise>


    suspend fun getBicBrest(week: Int): List<All_Exercise>
    suspend fun getTricBack(week: Int): List<All_Exercise>
    suspend fun getSholderLegs(week: Int): List<All_Exercise>

}