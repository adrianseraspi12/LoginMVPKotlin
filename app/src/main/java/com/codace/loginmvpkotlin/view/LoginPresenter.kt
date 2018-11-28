package com.codace.loginmvpkotlin.view

import com.codace.loginmvpkotlin.model.Credentials
import com.codace.loginmvpkotlin.interactor.IInteractor
import com.codace.loginmvpkotlin.interactor.InteractorImpl

class LoginPresenter(val interactorImpl: InteractorImpl,
                     var mView: ILoginContract.View): ILoginContract.Presenter {

    init {
        mView.setPresenter(this)
    }

    override fun login(credentials: Credentials) {
        mView.showProgressbar()

        interactorImpl.executeLogin(credentials, object: IInteractor {

            override fun loginSuccess() {
                mView.apply {
                    hideProgressbar()
                    onSuccess()
                }
            }

            override fun loginFailure(message: String) {
                mView.apply {
                    hideProgressbar()
                    onFailed(message)
                }
            }

        })
    }

}