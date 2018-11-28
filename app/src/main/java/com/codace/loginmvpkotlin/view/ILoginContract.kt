package com.codace.loginmvpkotlin.view

import com.codace.loginmvpkotlin.model.Credentials

interface ILoginContract {

    interface View {

        fun setPresenter(presenter: Presenter)

        fun showProgressbar()

        fun hideProgressbar()

        fun onSuccess()

        fun onFailed(message: String)

    }

    interface Presenter {

        fun login(credentials: Credentials)

    }

}