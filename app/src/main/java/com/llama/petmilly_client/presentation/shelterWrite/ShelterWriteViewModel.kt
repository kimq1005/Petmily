package com.llama.petmilly_client.presentation.shelterWrite

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.model.GenderType
import com.llama.petmilly_client.presentation.shelterWrite.model.ShelterWriteSideEffect
import com.llama.petmilly_client.presentation.shelterWrite.model.ShelterWriteState
import com.llama.petmilly_client.utils.Event
import com.llama.petmilly_client.utils.RemoteResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
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


    var isAlmostCompletedDialog by mutableStateOf(false)
        private set

    val files = mutableStateListOf<MultipartBody.Part>()
    val charmAppeal = mutableStateOf("")
    val isneutered = mutableStateOf("")
    val isinoculation = mutableStateOf("")
    val animalhealth = mutableStateOf("")
    val animalskill = mutableStateOf("")
    val animalpersonality = mutableStateOf("")

    val pickup = mutableStateOf("")

    val contions = mutableStateOf("")


    //    var temporaryProtectionCondition: MutableList<String> = arrayListOf()
    val temporaryProtectionCondition = mutableStateListOf<String>()
    val temporaryProtectionConditionList: MutableList<String> = arrayListOf()

    val temporaryProtectionHope = mutableStateListOf<String>()
    val temporaryProtectionHopeList: MutableList<String> = arrayListOf()

    val temporaryProtectionNo = mutableStateListOf<String>()
    val temporaryProtectionNoList: MutableList<String> = arrayListOf()

    val hopepeople = mutableStateOf("")
    val nopeople = mutableStateOf("")

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
        petName: String
    ) = intent {
        reduce {
            state.copy(petName = petName)
        }
    }

    fun setPetGender(
        gender: GenderType
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

    fun onShownAlmostCompetedDialog() {
        isAlmostCompletedDialog = true
    }

    fun onDismissAlmostCompetedDialog() {
        isAlmostCompletedDialog = false
    }

    fun addtemporaryProtectionCondition(text: String) {
        temporaryProtectionCondition.add(text)
        temporaryProtectionConditionList.add(text)
        Log.d(TAG, "addtemporaryProtectionCondition: $temporaryProtectionConditionList")

    }

    fun deletetemporaryProtectionCondition(text: String) {
        temporaryProtectionCondition.remove(text)
        temporaryProtectionConditionList.remove(text)
    }


    fun addtemporaryProtectionHope(text: String) {
        temporaryProtectionHope.add(text)
        temporaryProtectionHopeList.add(text)

        Log.d(TAG, "addtemporaryProtectionHope: $temporaryProtectionHopeList")
    }

    fun deletetemporaryProtectionHope(text: String) {
        temporaryProtectionHope.remove(text)
        temporaryProtectionHopeList.remove(text)


    }

    fun addtemporaryProtectionNo(text: String) {
        temporaryProtectionNo.add(text)
        temporaryProtectionNoList.add(text)
        Log.d(TAG, "addtemporaryProtectionNo: $temporaryProtectionNoList")
    }

    fun deletetemporaryProtectionNo(text: String) {
        temporaryProtectionNo.remove(text)
        temporaryProtectionNoList.remove(text)
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