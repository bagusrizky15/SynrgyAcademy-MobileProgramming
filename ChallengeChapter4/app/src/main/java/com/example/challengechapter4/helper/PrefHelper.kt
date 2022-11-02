package com.example.challengechapter4.helper

import android.content.Context
import androidx.core.content.edit

class PrefHelper(context: Context) {
    private val sharedPreferencesName = "SharedPreferencesBinar"
    private var preferences = context.getSharedPreferences(sharedPreferencesName, 0)

    var isLogin: Boolean
        set(value) {
            preferences.edit{
                putBoolean("IS_LOGIN", value)
            }
        }
        get() = preferences.getBoolean("IS_LOGIN", false)
}