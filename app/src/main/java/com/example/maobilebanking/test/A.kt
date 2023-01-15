//package com.example.maobilebanking.test
//
//import android.content.Context
//import dagger.Binds
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Inject
//
//interface A{
//
//}
//
//
//class Aimpl @Inject constructor():A {
//
//}
//
//class B @Inject constructor(
//    private val a:A
//)
//
////module
//@Module
//@InstallIn(SingletonComponent::class)//lifescycle
//interface AB {
//
//    @Binds
//    fun bindsAtoAimpl(impl:Aimpl):A
//
//}
//
//@Module
//@InstallIn(SingletonComponent::class)//lifescycle
//class AppDatabaseProvider {
//
//
//}
