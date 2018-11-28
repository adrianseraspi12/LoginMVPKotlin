package com.codace.loginmvpkotlin.interactor

interface IInteractor {

    fun loginSuccess()

    fun loginFailure(message: String)

}