package com.the.fitness.domain

data class All_Exercise(
    val id: Long? = null,
    val name: String? = null,
    val muscleGroup: String? = null,
    val description: String? = null,
    val weight: String? = null,
    val numbers: String? = null,
    val sets: String? = null,
    val imagePath: String? = null

)


data class ExercisesState(

    val items: List<All_Exercise> = emptyList(),

    )