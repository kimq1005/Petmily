package com.llama.petmilly_client.presentation.shelterWrite

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.domain.usecase.shelter.PostTemporaryProtectionUseCase
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.model.GenderType
import com.llama.petmilly_client.presentation.shelterWrite.model.NeuteringType
import com.llama.petmilly_client.presentation.shelterWrite.model.PickUpType
import com.llama.petmilly_client.presentation.shelterWrite.model.ShelterWriteSideEffect
import com.llama.petmilly_client.presentation.shelterWrite.model.ShelterWriteState
import com.llama.petmilly_client.presentation.shelterWrite.model.VaccinationType
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
    private val postTemporaryProtectionUseCase: PostTemporaryProtectionUseCase,
) : ViewModel(), ContainerHost<ShelterWriteState, ShelterWriteSideEffect> {

    @RequiresApi(Build.VERSION_CODES.O)
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

    fun setPetSpecies(species: PetCategoryType) = intent {
        reduce {
            state.copy(petCategoryType = species)
        }
    }

    fun setPetName(petName: String) = intent {
        reduce {
            state.copy(petName = petName)
        }
    }

    fun setPetGender(gender: GenderType) = intent {
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

    fun setCharmAppeal(value: String) = blockingIntent {
        reduce {
            state.copy(
                charmAppeal = value
            )
        }
    }

    fun setStartReceptionPeriod(value: String) = blockingIntent {
        reduce {
            state.copy(
                startReceptionPeriod = value
            )
        }
    }

    fun setEndReceptionPeriod(value: String) = blockingIntent {
        reduce {
            state.copy(
                endReceptionPeriod = value
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun postTemporaryProtection() = intent {
        postTemporaryProtectionUseCase(
            files = state.petPhotoFile,
            charmAppeal = state.charmAppeal,
            animalTypes = state.petCategoryType ?: PetCategoryType.PUPPY,
            name = state.petName,
            gender = state.gender ?: GenderType.MALE,
            weight = state.weight,
            breed = state.species,
            age = state.age,
            neutered = state.neuteredType ?: NeuteringType.NEUTERED,
            inoculation = state.vaccinationType ?: VaccinationType.UN_VACCINATED,
            health = state.health,
            skill = state.skill,
            character = state.personality,
            pickUp = state.pickUpType ?: PickUpType.DIRECT_PICKUP,
            startReceptionPeriod = state.startReceptionPeriodToLocalDateTime(),
            endReceptionPeriod = state.endReceptionPeriodToLocalDateTime(),
            temporaryProtectionCondition = state.tenancyCondition,
            temporaryProtectionHope = state.hopePeoples,
            temporaryProtectionNo = state.noPeoples,
        )

        postSideEffect(ShelterWriteSideEffect.Finish)
    }
}