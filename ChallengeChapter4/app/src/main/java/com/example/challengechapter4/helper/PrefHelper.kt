package com.example.challengechapter4.helper

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PrefHelper(context: Context) {
    private val PREF_NAME = "SharedPreferencesBinar"
    private val preferences : SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        preferences = context.getSharedPreferences(PREF_NAME, 0)
        editor = preferences.edit()
    }

    fun put(key:String, value: String){
        editor.putString(key, value)
            .apply()
    }

    fun getString(key: String): String? {
        return preferences.getString(key, null)
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key,value)
            .apply()
    }
    fun getBoolean(key: String, value: Boolean): Boolean {
        return preferences.getBoolean(key, false)
    }

    fun clear(){
        editor.clear()
            .apply()
    }

}
//
//    var isLogin: Boolean
//        set(value) {
//            preferences.edit{
//                putBoolean("IS_LOGIN", value)
//            }
//        }
//        get() = preferences.getBoolean("IS_LOGIN", false)
//}