package com.the.fitness.data

import com.the.fitness.domain.All_Exercise


fun Exercise.toDomain() = All_Exercise(id = id, name = name, muscleGroup = muscleGroup,   imagePath =  imagePath)
fun BicepsBrest.toDomain() = All_Exercise(id =id, name =name, muscleGroup =muscleGroup,  imagePath =  imagePath, description = description, weight = weight, numbers = numbers, sets = sets)
fun TricepsBack.toDomain() = All_Exercise(id =id, name =name, muscleGroup =muscleGroup,  imagePath =  imagePath, description = description, weight = weight, numbers = numbers, sets = sets)
fun ShoulderLegs.toDomain() = All_Exercise(id =id, name =name, muscleGroup =muscleGroup,  imagePath =  imagePath, description = description, weight = weight, numbers = numbers, sets = sets)
