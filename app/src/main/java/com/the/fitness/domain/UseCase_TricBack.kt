package com.the.fitness.domain

class UseCase_TricBack (private val tricBack_repo: Repository) {
    suspend operator fun invoke(week: Int): List<All_Exercise> {
        return tricBack_repo.getTricBack(week)
    }

}