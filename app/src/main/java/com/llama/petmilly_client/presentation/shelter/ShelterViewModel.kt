package com.llama.petmilly_client.presentation.shelter

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.data.model.shelter.PostDTO
import com.llama.petmilly_client.data.model.shelter.PostDataDetailDTO
import com.llama.petmilly_client.data.model.shelter.TemporaryDetailDTO
import com.llama.petmilly_client.data.model.shelter.TemporaryPhotoUrlDTO
import com.llama.petmilly_client.data.model.shelter.ProtectionConditionDTO
import com.llama.petmilly_client.data.model.shelter.ProtectionHopeDTO
import com.llama.petmilly_client.data.model.shelter.ProtectionNoDTO
import com.llama.petmilly_client.data.model.shelter.TemporaryDTO
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.domain.usecase.shelter.GetShelterPostUseCase
import com.llama.petmilly_client.domain.usecase.shelter.GetTemporaryDetailUseCase
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeCategoryType
import com.llama.petmilly_client.presentation.shelter.model.ShelterSideEffect
import com.llama.petmilly_client.presentation.shelter.model.ShelterState
import com.llama.petmilly_client.utils.RemoteResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
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
class ShelterViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
    private val shelterPostUseCase: GetShelterPostUseCase,
    private val getTemporaryDetailUseCase: GetTemporaryDetailUseCase,
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

    var isAdoptionApplicationDialogShown by mutableStateOf(false)
        private set

    var isjudge = mutableStateOf(1)

    val cat = mutableStateOf(true)
    val dog = mutableStateOf(true)
    val isComplete = mutableStateOf(false)
    val weight = mutableListOf<String>()
    val categorylist: MutableList<String> = arrayListOf()

    val postDto: MutableLiveData<PostDTO> = MutableLiveData<PostDTO>()
    val postDataList = mutableStateListOf<PostDataDetailDTO>()

    //임보처 구해요 상세조회
    val id = mutableStateOf(0)
    val temporarydetailDTO: MutableLiveData<TemporaryDTO> =
        MutableLiveData<TemporaryDTO>()
    val temporarydetailList = mutableStateListOf<TemporaryDetailDTO>()

    val charmAppeal_detail = mutableStateOf("")
    val name_detail = mutableStateOf("")
    val gender_detail = mutableStateOf("")
    val weight_detail = mutableStateOf("")
    val breed_detail = mutableStateOf("")
    val age_detail = mutableStateOf("")
    val neutered_detail = mutableStateOf("")
    val inoculation_detail = mutableStateOf("")
    val health_detail = mutableStateOf("")
    val skill_detail = mutableStateOf("")
    val character_detail = mutableStateOf("")
    val pickUp_detail = mutableStateOf("")
    val receptionPeriod_detail = mutableStateOf("")
    val isReceipt_detail = mutableStateOf(false)
    val isCompleted_detail = mutableStateOf(false)
    val shortName_detail = mutableStateOf("")
    val thumbnail_detail = mutableStateOf("")
    val photoUrl_detail = mutableStateListOf<TemporaryPhotoUrlDTO>()

    val ProtectionCondition = mutableStateListOf<ProtectionConditionDTO>()
    val ProtectionHope = mutableStateListOf<ProtectionHopeDTO>()
    val ProtectionNo = mutableStateListOf<ProtectionNoDTO>()

    init {
        initData()
    }

    private fun initData(
        isDog: Boolean = false,
        isCat: Boolean = false,
        isCompleted: Boolean = false,
        weightList: List<ShelterSafeCategoryType> = emptyList(),
    ) = intent {
        val data = shelterPostUseCase(
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

    fun getTemporaryDetail(
        id: Int
    ) = intent {
        val data = getTemporaryDetailUseCase(id).getOrThrow()
        reduce {
            state.copy(
                temporaryDetail = data.data
            )
        }
    }

    fun gettemporarydetail() {
        viewModelScope.launch(Dispatchers.IO) {
            petMillyRepo.getTemporaryDetail(
                id.value
            ).let {
                when (it.status) {
                    RemoteResult.Status.SUCCESS -> {
                        it.data?.let { item ->
                            val data = item.data
                            temporarydetailDTO.postValue(item)
                            charmAppeal_detail.value = data.charmAppeal
                            name_detail.value = data.name
                            gender_detail.value = data.gender
                            weight_detail.value = data.weight.toString()
                            breed_detail.value = data.breed.toString()
                            age_detail.value =
                                if (data.age > 1) "${data.age.toInt()}살 추정" else "${data.age * 10}개월 추정"
                            neutered_detail.value = data.neutered
                            inoculation_detail.value = data.inoculation
                            health_detail.value = data.health
                            skill_detail.value = data.skill
                            character_detail.value = data.character
                            pickUp_detail.value = data.pickUp
                            receptionPeriod_detail.value = data.receptionPeriod
                            isReceipt_detail.value = data.isReceipt
                            isCompleted_detail.value = data.isComplete
                            shortName_detail.value = data.addressInfo.shortName
                            thumbnail_detail.value = data.thumbnail?.photoUrl ?: ""
                            photoUrl_detail.addAll(data.photoUrls)

                            Log.d(TAG, "gettemporarydetail: $data")
                        }
//                        setProtectionCondition()
                    }

                    else -> {
                        Log.d(TAG, "gettemporarydetail ERROR: $it ")
                    }
                }
            }
        }
    }
}