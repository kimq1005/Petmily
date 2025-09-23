package com.llama.petmilly_client.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.BuildConfig
import com.llama.petmilly_client.domain.usecase.home.GetLibraryUseCase
import com.llama.petmilly_client.presentation.home.model.HomeSideEffect
import com.llama.petmilly_client.presentation.home.model.HomeState
import com.llama.petmilly_client.presentation.home.model.PetCategory
import com.llama.petmilly_client.presentation.home.model.ShelterCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLibraryUseCase: GetLibraryUseCase,
) : ViewModel(), ContainerHost<HomeState, HomeSideEffect> {

    override val container: Container<HomeState, HomeSideEffect> = container(
        initialState = HomeState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent {
                    postSideEffect(
                        HomeSideEffect.Error(message = throwable.message.orEmpty())
                    )
                }
            }
        }
    )

    init {
        getLibrary()
    }

    private fun getLibrary(
        startIndex: Int = 1,
    ) = intent {
        val data = getLibraryUseCase(
            key = BuildConfig.LIBRARY_API_KEY,
            startIndex = startIndex,
            endIndex = 20
        ).getOrThrow()

        reduce {
            state.copy(petData = data.libraryDTO.clusterRow)
        }

        Log.d(TAG, "getLibrary Success: $data")
    }

    fun onClickPetCategory(
        petCategory: PetCategory,
    ) = intent {
        reduce {
            state.copy(
                selectedPetCategory = state.selectedPetCategory.toMutableList().apply {
                    val contains = state.selectedPetCategory.contains(petCategory)

                    if (!contains) {
                        clear()
                        add(petCategory)
                    } else {
                        remove(petCategory)
                    }
                }
            )
        }

        getLibrary(2)
    }

    fun onClickShelterCategory(
        shelterCategory: ShelterCategory,
    ) = intent {

        reduce {
            state.copy(
                selectedShelterCategory = state.selectedShelterCategory.toMutableList().apply {
                    val contains = state.selectedShelterCategory.contains(shelterCategory)
                    if (!contains) {
                        clear()
                        add(shelterCategory)
                    } else {
                        remove(shelterCategory)
                    }
                })
        }

        getLibrary(3)
    }

    fun onClusterClick() = intent {
        if (state.selectedShelterCategory.isNotEmpty()) postSideEffect(HomeSideEffect.NavigateToActivity(state.selectedShelterCategory[0]))
    }
}

//TOdo: 추후 삭제 예정
data class CategoryTest(
    var title: String,
)