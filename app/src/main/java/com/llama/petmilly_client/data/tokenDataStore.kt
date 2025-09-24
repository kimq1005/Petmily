package com.llama.petmilly_client.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "token")

class TokenDataStore @Inject constructor(
    private val context: Context,
){
    companion object {
        private val TOKEN = stringPreferencesKey("token")
    }

    suspend fun setToken(token: String) {
        context.dataStore.edit { pref ->
            pref[TOKEN] = token
        }
    }

    suspend fun getToken(): String? {
        return context.dataStore.data.map {
            it[TOKEN]
        }.firstOrNull()
    }

    suspend fun clearToken() {
        context.dataStore.edit { it.clear() }
    }
}