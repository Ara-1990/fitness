package com.the.fitness.di


import android.content.Context
import androidx.room.Room
import com.the.fitness.data.AppDatabase
import com.the.fitness.data.Dao
import com.the.fitness.data.RepositoryImpl
import com.the.fitness.domain.UseCase_BicBrest
import com.the.fitness.domain.Repository
import com.the.fitness.domain.UseCase_AllExers
import com.the.fitness.domain.UseCase_SholdLegs
import com.the.fitness.domain.UseCase_TricBack
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext ctx: Context): AppDatabase =
        AppDatabase.getDatabase(ctx)


    @Provides
    fun provideExerciseDao(db: AppDatabase) = db.exerciseDao()


    @Provides @Singleton
    fun provideExerciseRepo(dao: Dao): Repository =
        RepositoryImpl(dao)


    @Provides fun provideUseCase_AllExers(repo: Repository) = UseCase_AllExers(repo)
    @Provides fun provideUseCase_BicBrest(repo: Repository) = UseCase_BicBrest(repo)
    @Provides fun provideUseCase_TricBack(repo: Repository) = UseCase_TricBack(repo)
    @Provides fun provideUseCase_SholdLegs(repo: Repository) = UseCase_SholdLegs(repo)

}