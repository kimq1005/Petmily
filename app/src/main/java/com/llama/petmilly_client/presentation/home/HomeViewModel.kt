package com.llama.petmilly_client.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.BuildConfig
import com.llama.petmilly_client.domain.usecase.home.GetLibraryUseCase
import com.llama.petmilly_client.presentation.home.model.HomeSideEffect
import com.llama.petmilly_client.presentation.home.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
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
    private val getLibraryUseCase: GetLibraryUseCase
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

    val categorytest: MutableList<CategoryTest> = arrayListOf()

    init {
        getLibrary()
    }

    fun setCategory() {
        categorytest.clear()

        val puppy = CategoryTest("강아지")
        val cat = CategoryTest("고양이")
        val entity = CategoryTest("petmily ❤️")
        val saveshelter = CategoryTest("임보처구해요")
        val findmybaby = CategoryTest("우리아이 찾아요")
        val movevolunteer = CategoryTest("이동봉사 찾아요")
        val adoptionnotice = CategoryTest("입양 공고")

        categorytest.add(puppy)
        categorytest.add(cat)
        categorytest.add(entity)
        categorytest.add(saveshelter)
        categorytest.add(findmybaby)
        categorytest.add(movevolunteer)
        categorytest.add(adoptionnotice)
        categorytest.add(adoptionnotice)
    }

    private fun getLibrary() = intent {
        val data = getLibraryUseCase(
            key = BuildConfig.LIBRARY_API_KEY,
            startIndex = 1,
            endIndex = 20
        ).getOrThrow()

        reduce {
            state.copy(petData = data.libraryDTO.clusterRow)
        }

        Log.d(TAG, "getLibrary Success: $data")
    }
}


data class CategoryTest(
    var title: String,
)