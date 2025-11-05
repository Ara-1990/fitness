package com.the.fitness.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    @Query("SELECT * FROM exercises ORDER BY name ASC")
    suspend fun getAll(): List<Exercise>


    @Query("SELECT * FROM brest_biceps WHERE week = :week ORDER BY name ASC")
    suspend fun getBicBrest(week: Int): List<BicepsBrest>


    @Query("SELECT * FROM back_triceps WHERE week = :week ORDER BY name ASC")
    suspend fun getTricepsBack(week: Int): List<TricepsBack>


    @Query("SELECT * FROM legs_shoulder WHERE week = :week ORDER BY name ASC")
    suspend fun getShoulderLegs(week: Int): List<ShoulderLegs>



}