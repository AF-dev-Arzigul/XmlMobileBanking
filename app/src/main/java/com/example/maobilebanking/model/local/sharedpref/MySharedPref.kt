package com.example.maobilebanking.model.local.sharedpref

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MySharedPref  @Inject constructor(){
    private val IS_FIRST="isFirst"
    companion object{
        private var mySharedPref:MySharedPref?=null
        private var sharedPreferences: SharedPreferences?=null
        fun init(context: Context){
            if (mySharedPref==null){
                mySharedPref= MySharedPref()
                sharedPreferences=context.getSharedPreferences("myShared",Context.MODE_PRIVATE)
            }
        }
        fun getMyShared()= mySharedPref!!
    }

    var isFirst:Boolean
    set(value)  = sharedPreferences?.edit()?.putBoolean(IS_FIRST, value)!!.apply()
    get() = sharedPreferences!!.getBoolean(IS_FIRST,false)

}