package com.codace.loginmvpkotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.codace.loginmvpkotlin.R
import com.codace.loginmvpkotlin.interactor.InteractorImpl

class LoginActivity : AppCompatActivity() {

    companion object {
        val VIEW: String = "VIEW"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val manager: FragmentManager = this.supportFragmentManager

        //Elvis OperatorDataModel:
        //if (object/function) returns/is null :? do this
        val loginFragment = manager.findFragmentByTag(VIEW) as LoginFragment?
            ?: LoginFragment.newInstance()

        manager.beginTransaction().replace(R.id.login_container, loginFragment).commit()

        LoginPresenter(InteractorImpl(), loginFragment)
    }

}
