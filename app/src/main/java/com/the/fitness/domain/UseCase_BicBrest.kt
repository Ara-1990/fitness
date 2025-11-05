package com.the.fitness.domain

class UseCase_BicBrest (private val bicBrest_rep: Repository) {

    suspend operator fun invoke(week: Int): List<All_Exercise> {
        return bicBrest_rep.getBicBrest(week)
    }

}