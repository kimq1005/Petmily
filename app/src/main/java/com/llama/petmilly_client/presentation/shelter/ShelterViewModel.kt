package com.llama.petmilly_client.presentation.shelter

import android.util.Log
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.domain.usecase.shelter.GetShelterPostUseCase
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeCategoryType
import com.llama.petmilly_client.presentation.shelter.model.ShelterSideEffect
import com.llama.petmilly_client.presentation.shelter.model.ShelterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ShelterViewModel @Inject constructor(
    private val getShelterPostUseCase: GetShelterPostUseCase,
) : ViewModel(), ContainerHost<ShelterState, ShelterSideEffect> {

    override val container: Container<ShelterState, ShelterSideEffect> = container(
        initialState = ShelterState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent {
                    postSideEffect(
                        ShelterSideEffect.Error(message = throwable.message.orEmpty())
                    )
                }
            }
        }
    )

    init {
        initData()
    }

    private fun initData(
        isDog: Boolean = false,
        isCat: Boolean = false,
        isCompleted: Boolean = false,
        weightList: List<ShelterSafeCategoryType> = emptyList(),
    ) = intent {
        val data = getShelterPostUseCase(
            page = 0,
            limit = 5,
            dog = isDog,
            cat = isCat,
            isComplete = isCompleted,
            weight = weightList,
            type = "temporaryProtection"
        ).getOrThrow()

        reduce {
            state.copy(
                postDataList = data.data?.list ?: emptyList()
            )
        }
    }

    fun onCategoryClick(
        selectedCategory: ShelterSafeCategoryType,
    ) = intent {
        val newSelectedCategory = state.selectedCategory.toMutableList().apply {
            val contains = state.selectedCategory.contains(selectedCategory)
            if (!contains) {
                add(selectedCategory)
            } else {
                remove(selectedCategory)
            }
        }
        reduce {
            state.copy(
                selectedCategory = newSelectedCategory
            )
        }

        val isDog = state.selectedCategory.contains(ShelterSafeCategoryType.PUPPY)
        val isCat = state.selectedCategory.contains(ShelterSafeCategoryType.CAT)
        val isCompleted = state.selectedCategory.contains(ShelterSafeCategoryType.ENTITY)
        val weightList = listOf(
            ShelterSafeCategoryType.SMALL,
            ShelterSafeCategoryType.MIDDLE,
            ShelterSafeCategoryType.BIG
        ).filter { it in state.selectedCategory }

        Log.d(TAG, "getShelterPost: ${state.selectedCategory}")

        initData(
            isDog = isDog,
            isCat = isCat,
            isCompleted = isCompleted,
            weightList = weightList
        )
    }

    fun onFloatBtnClick() = intent {
        postSideEffect(ShelterSideEffect.NavigateToActivity)
    }
}