package com.the.fitness.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "exercises",indices = [Index(value = ["name","muscleGroup"], unique = true)])
data class Exercise(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val muscleGroup: String,
    val imagePath:String? = null)

@Entity(tableName = "brest_biceps")
data class BicepsBrest(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val muscleGroup: String,
    val imagePath:String? = null,
    val weight:String? = null,
    val numbers: String? = null,
    val sets: String? = null,
    val description: String? = null,
    val week: Int

)


@Entity(tableName = "back_triceps")
data class TricepsBack(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val muscleGroup: String,
    val imagePath:String? = null,
    val weight:String? = null,
    val numbers: String? = null,
    val sets: String? = null,
    val description: String? = null,
    val week: Int

)


@Entity(tableName = "legs_shoulder")
data class ShoulderLegs(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val muscleGroup: String,
    val imagePath:String? = null,
    val weight:String? = null,
    val numbers:String? = null,
    val sets: String? = null,
    val description: String? = null,
    val week: Int

)