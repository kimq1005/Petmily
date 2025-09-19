package com.llama.petmilly_client.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.llama.petmilly_client.domain.usecase.kakao.KakaoLoginUseCase
import com.llama.petmilly_client.domain.usecase.login.PostLoginUseCase
import com.llama.petmilly_client.presentation.login.model.LoginSideEffect
import com.llama.petmilly_client.presentation.login.model.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val postLoginUseCase: PostLoginUseCase,
) : ViewModel(), ContainerHost<LoginState, LoginSideEffect> {
    override val container: Container<LoginState, LoginSideEffect> = container(
        initialState = LoginState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent {
                    postSideEffect(
                        LoginSideEffect.Error(message = throwable.message.orEmpty()))
                }
            }
        }
    )

    fun onConfirm() = intent {
        postSideEffect(LoginSideEffect.NavigateToHomeActivity)
    }

    fun onDisConfirm() = intent {
        postSideEffect(LoginSideEffect.NavigateToNotificationActivity)
    }

    fun postKaKaoLogin(
        context: Context,
    ) = intent {
        runCatching { kakaoLoginUseCase(context).getOrThrow() }
            .onSuccess { token ->
                postLogin(token.accessToken)
            }.onFailure {
                postSideEffect(LoginSideEffect.Error(message = it.message.orEmpty()))
            }
    }

    private fun postLogin(
        token: String
    ) = intent {
        val response = postLoginUseCase(token)
        response.onSuccess {
            postSideEffect(LoginSideEffect.NavigateToHomeActivity)
        }.onFailure {
            postSideEffect(LoginSideEffect.Error(message = it.message.orEmpty()))
        }
    }
}