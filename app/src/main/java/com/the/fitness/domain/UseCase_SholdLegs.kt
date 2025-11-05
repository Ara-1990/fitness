package com.the.fitness.domain

class UseCase_SholdLegs(private val shoulderLegs_repo: Repository) {
    suspend operator fun invoke(week:Int): List<All_Exercise> {
        return shoulderLegs_repo.getSholderLegs(week)
    }

}