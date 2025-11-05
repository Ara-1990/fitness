package com.the.fitness.ui

import com.the.fitness.domain.ExercisesState
import com.the.fitness.domain.UseCase_AllExers
import com.the.fitness.domain.UseCase_BicBrest
import com.the.fitness.domain.UseCase_SholdLegs
import com.the.fitness.domain.UseCase_TricBack
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import kotlinx.coroutines.launch


@HiltViewModel
class ViewModel @Inject constructor(
    private val getAllExUseCase:UseCase_AllExers,
    private val bicepsBrestUseCase:UseCase_BicBrest,
    private val tricBackUseCase:UseCase_TricBack,
    private val shoulderLegs:UseCase_SholdLegs,
): ViewModel(){


    private val _ui_state = MutableStateFlow(ExercisesState())
    val ui_state: StateFlow<ExercisesState> = _ui_state


    private var syncJob: Job? = null


    fun refresh(week: Int, workout: Int){
        syncJob = viewModelScope.launch{
            val result = when (workout) {
                1 -> getAllExUseCase.invoke()
                2 -> bicepsBrestUseCase.invoke(week)
                3 -> tricBackUseCase.invoke(week)
                4 -> shoulderLegs.invoke(week)
                else -> emptyList()
            }


            _ui_state.value = _ui_state.value.copy(items = result)

        }
    }

}