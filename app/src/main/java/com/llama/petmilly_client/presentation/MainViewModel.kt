package com.llama.petmilly_client.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llama.petmilly_client.MainApplication
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import com.llama.petmilly_client.presentation.login.model.LoginSideEffect
import com.llama.petmilly_client.presentation.login.model.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val petMillyRepo: PetMillyRepo
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

    fun postkakaotoken() {
        if (MainApplication.kakaoaccesesstoken != "") {
            viewModelScope.launch(Dispatchers.IO) {
                val kaKaoResponse = KaKaoResponse(MainApplication.kakaoaccesesstoken)
                petMillyRepo.postkakaotoken(kaKaoResponse).let {
                    when (it.status) {
                        RemoteResult.Status.SUCCESS -> {
                            it.data?.let { data ->
                                Log.d(TAG, "postkakaotoken: $data")
                                Log.d(TAG, "postkakaotoken: ${data.data.tokenList.accessToken}")
                                Log.d(TAG, "postkakaotoken: ${data.data.isExistAdditionalInfo}")
                                val accessToken = data.data.tokenList.accessToken
                                val refreshToken = data.data.tokenList.refreshToken

                                MainApplication.accessToken = accessToken ?: ""
                                MainApplication.refreshToken = refreshToken ?: ""

                                if (!data.data.isExistAdditionalInfo) {

                                } else {
                                    if (MainApplication.accessToken != "" && MainApplication.refreshToken != "") {

                                    }
                                }


                            }
                        }
                        RemoteResult.Status.REFRESH -> {
                            Log.d(TAG, "postkakaotoken Refresh: ${it.status}->${it.message}")
                        }

                        RemoteResult.Status.ERROR -> {
                            Log.d(TAG, "postkakaotoken ERROR: ${it.status}->${it.message}")
                        }

                        else -> {
                            Log.d(TAG, "postkakaotoken: ${it}")


                        }
                    }
                }
            }
        }

    }
}