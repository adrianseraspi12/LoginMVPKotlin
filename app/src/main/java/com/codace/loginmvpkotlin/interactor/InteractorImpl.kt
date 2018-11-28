package com.codace.loginmvpkotlin.interactor

import android.os.Handler
import com.codace.loginmvpkotlin.model.Credentials

class InteractorImpl {

    fun executeLogin(credentials: Credentials, interactorListener: IInteractor) {
        Handler().apply {
            val runnable = object: Runnable {

                override fun run() {

                    if (credentials.isValid()) {
                        interactorListener.loginSuccess()
                    }
                    else {
                        interactorListener.loginFailure("Invalid Credentials")
                    }

                }

            }

            postDelayed(runnable, 3000)
        }
    }

}