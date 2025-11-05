package com.the.fitness.data


import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Exercise::class, BicepsBrest::class, TricepsBack::class, ShoulderLegs::class],
    version = 1, exportSchema = true
)

abstract class AppDatabase:RoomDatabase() {


    abstract fun exerciseDao(): Dao


    companion object {


        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fitness_db"
                )

                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }

            }

        }
}