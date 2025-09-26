package com.llama.petmilly_client.presentation.shelter

import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.domain.usecase.shelter.GetTemporaryDetailUseCase
import com.llama.petmilly_client.presentation.shelter.model.ShelterDetailSideEffect
import com.llama.petmilly_client.presentation.shelter.model.ShelterDetailState
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class ShelterDetailViewModel @Inject constructor(
    private val getTemporaryDetailUseCase: GetTemporaryDetailUseCase,
) : ViewModel(), ContainerHost<ShelterDetailState, ShelterDetailSideEffect> {

    override val container: Container<ShelterDetailState, ShelterDetailSideEffect> = container(
        initialState = ShelterDetailState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent {
                   postSideEffect(
                       ShelterDetailSideEffect.Error(message = throwable.message.toString())
                   )
                }
            }
        }
    )

    fun initData(
        id: Int,
    ) = intent {
        val data = getTemporaryDetailUseCase(id).getOrThrow()
        reduce {
            state.copy(
                temporaryDetail = data.data
            )
        }
    }
}