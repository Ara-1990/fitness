package com.the.fitness.domain

class UseCase_AllExers(private val exer_repo: Repository) {


    suspend operator fun invoke(): List<All_Exercise> {
        return exer_repo.getAll()
    }
}