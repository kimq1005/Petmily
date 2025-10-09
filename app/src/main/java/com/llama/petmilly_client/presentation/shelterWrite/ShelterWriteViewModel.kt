package com.llama.petmilly_client.presentation.shelterWrite

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.model.GenderType
import com.llama.petmilly_client.presentation.shelterWrite.model.NeuteringType
import com.llama.petmilly_client.presentation.shelterWrite.model.PickUpType
import com.llama.petmilly_client.presentation.shelterWrite.model.ShelterWriteSideEffect
import com.llama.petmilly_client.presentation.shelterWrite.model.ShelterWriteState
import com.llama.petmilly_client.presentation.shelterWrite.model.VaccinationType
import com.llama.petmilly_client.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import okhttp3.MultipartBody
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@OptIn(OrbitExperimental::class)
@HiltViewModel
class ShelterWriteViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo,
) : ViewModel(), ContainerHost<ShelterWriteState, ShelterWriteSideEffect> {

    override val container: Container<ShelterWriteState, ShelterWriteSideEffect> = container(
        initialState = ShelterWriteState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent {
                    postSideEffect(
                        ShelterWriteSideEffect.Error(message = throwable.message.orEmpty())
                    )
                }
            }
        }
    )

    private val _setcompleted = MutableLiveData<Event<Unit>>()
    val setcompleted: LiveData<Event<Unit>> = _setcompleted

    val charmAppeal = mutableStateOf("")

    val apstartyear = mutableStateOf("")
    val apendyear = mutableStateOf("")

    fun setPetSpecies(
        species: PetCategoryType,
    ) = intent {
        reduce {
            state.copy(petCategoryType = species)
        }
    }

    fun setPetName(
        petName: String,
    ) = intent {
        reduce {
            state.copy(petName = petName)
        }
    }

    fun setPetGender(
        gender: GenderType,
    ) = intent {
        reduce {
            state.copy(gender = gender)
        }
    }

    fun setUploadFile(file: MultipartBody.Part) = intent {
        reduce {
            state.copy(petPhotoFile = state.petPhotoFile + file)
        }
    }

    fun setDeleteFile(file: MultipartBody.Part) = intent {
        reduce {
            state.copy(petPhotoFile = state.petPhotoFile - file)
        }
    }

    fun setUploadUri(uri: Uri) = intent {
        reduce {
            state.copy(petPhotoUri = state.petPhotoUri + uri)
        }
    }

    fun setDeleteUri(uri: Uri) = intent {
        reduce {
            state.copy(petPhotoUri = state.petPhotoUri - uri)
        }
    }

    fun setWeight(weight: String) = blockingIntent {
        reduce {
            state.copy(weight = weight)
        }
    }

    fun setAge(age: String) = blockingIntent {
        reduce {
            state.copy(age = age)
        }
    }

    fun setSpecies(species: String) = blockingIntent {
        reduce {
            state.copy(species = species)
        }
    }

    fun setNeuteredType(neuteringType: NeuteringType?) = intent {
        reduce {
            state.copy(neuteredType = neuteringType)
        }
    }

    fun setVaccinationType(vaccinationType: VaccinationType?) = intent {
        reduce {
            state.copy(vaccinationType = vaccinationType)
        }
    }

    fun setHealth(value: String) = blockingIntent {
        reduce {
            state.copy(
                health = value
            )
        }
    }

    fun setSkill(value: String) = blockingIntent {
        reduce {
            state.copy(
                skill = value
            )
        }
    }

    fun setPersonality(value: String) = blockingIntent {
        reduce {
            state.copy(
                personality = value
            )
        }
    }

    fun setPickUpType(pickUpType: PickUpType) = intent {
        reduce {
            state.copy(pickUpType = pickUpType)
        }
    }

    fun setTemporaryCondition(value: String) = intent {
        reduce {
            state.copy(
                tenancyCondition = if (state.tenancyCondition.contains(value))
                    state.tenancyCondition - value
                else
                    state.tenancyCondition + value
            )
        }
    }

    fun setHopePeoples(value: String) = intent {
        reduce {
            state.copy(
                hopePeoples = if (state.hopePeoples.contains(value))
                    state.hopePeoples - value
                else
                    state.hopePeoples + value
            )
        }
    }

    fun setNoPeoples(value: String) = intent {
        reduce {
            state.copy(
                noPeoples = if (state.noPeoples.contains(value))
                    state.noPeoples - value
                else
                    state.noPeoples + value
            )
        }
    }

    //    fun posttemporaryprotection() {
//
//
////        val dateString = hopeapplicationperiod.value
//
//        val temporaryProtectionCondition: List<RequestBody> = temporaryProtectionConditionList.map {
//            RequestBody.create("text/plain".toMediaTypeOrNull(), it)
//        }
//
//        val temporaryProtectionHope: List<RequestBody> = temporaryProtectionHopeList.map {
//            RequestBody.create("text/plain".toMediaTypeOrNull(), it)
//        }
//
//        val temporaryProtectionNo: List<RequestBody> =
//            temporaryProtectionNoList.map {
//                RequestBody.create("text/plain".toMediaTypeOrNull(), it)
//            }
//        val now = LocalTime.now()
//
//        viewModelScope.launch(Dispatchers.IO) {
//            petMillyRepo.postTemporaryProtection(
//                files ?: null,
//                charmAppeal.value,
//                state,
//                animalname,
//                animalsex,
//                animalkg,
//                animaldetailspecies,
//                animalage,
//                isneutered,
//                isinoculation,
//                animalhealth,
//                animalskill,
//                animalpersonality,
//                pickup,
//                startReceptionPeriod = if (apstartyear.value != "") {
//                    val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
//                    val dateString = "${apstartyear.value} 10:00:00"
//                    val date = LocalDateTime.parse(dateString, formatter)
//                    val hopeapplicationperiod =
//                        RequestBody.create("text/plain".toMediaTypeOrNull(), date.toString())
//                    hopeapplicationperiod
//                } else null,
//                endReceptionPeriod = if (apendyear.value != "") {
//                    val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")
//                    val dateString = "${apendyear.value} 10:00:00"
//                    val date = LocalDateTime.parse(dateString, formatter)
//                    val hopeapplicationperiod =
//                        RequestBody.create("text/plain".toMediaTypeOrNull(), date.toString())
//                    hopeapplicationperiod
//                } else null,
//                temporaryProtectionCondition ?: null,
//                temporaryProtectionHope ?: null,
//                temporaryProtectionNo ?: null
//            ).let {
//                when (it.status) {
//                    RemoteResult.Status.SUCCESS -> {
//                        Log.d(TAG, "posttemporaryprotection SUCCESS: $it")
//                        _setcompleted.postValue(Event(Unit))
//                    }
//
//                    else -> {
//                        Log.d(TAG, "posttemporaryprotection ERROR: $it")
////                        _setnotcompleted.postValue(it.message)
//                    }
//
//                }
//            }
//        }
//    }
}