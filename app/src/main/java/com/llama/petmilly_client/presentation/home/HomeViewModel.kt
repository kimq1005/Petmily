package com.llama.petmilly_client.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.domain.repository.GetLibraryRepo
import com.llama.petmilly_client.presentation.home.model.HomeSideEffect
import com.llama.petmilly_client.presentation.home.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import com.llama.petmilly_client.utils.RemoteResult
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLibraryRepo: GetLibraryRepo,
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

    val APIKEY = "6b684a65456b696d3333794b66704f"

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

    private fun getLibrary() {
        viewModelScope.launch(Dispatchers.IO) {
            getLibraryRepo.getLibrary(APIKEY, 1, 20).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let { data ->
//                            _yeahman.postValue(data.SeoulPublicLibraryInfoDTO.clusterRow)
                            Log.d(TAG, "getLibrary success ${data}")
                        }
                    }

                    else -> {
                        Log.d(TAG, "getLibrary error: $it")
                    }
                }
            }
        }
    }
}


data class CategoryTest(
    var title: String,
)