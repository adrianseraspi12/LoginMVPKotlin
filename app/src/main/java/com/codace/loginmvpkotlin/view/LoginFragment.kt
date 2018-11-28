package com.codace.loginmvpkotlin.view


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.codace.loginmvpkotlin.model.Credentials
import com.codace.loginmvpkotlin.MainActivity
import com.codace.loginmvpkotlin.R

class LoginFragment :Fragment(), ILoginContract.View {

    companion object {
        fun newInstance(): LoginFragment = LoginFragment()
    }

    private lateinit var presenter: ILoginContract.Presenter

    private lateinit var usernameView: EditText
    private lateinit var passwordView: EditText
    private lateinit var loginButton: Button
    private lateinit var progressbar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        usernameView = view.findViewById(R.id.editText)
        passwordView = view.findViewById(R.id.editText2)
        loginButton = view.findViewById(R.id.loginButton)
        progressbar = view.findViewById(R.id.login_progressbar)

        loginButton.setOnClickListener {
            val username = usernameView.text.toString()
            val password = passwordView.text.toString()
            val credentials = Credentials(username, password)

            presenter.login(credentials)
        }

        return view
    }

    override fun setPresenter(presenter: ILoginContract.Presenter) {
        this.presenter = presenter
    }

    override fun showProgressbar() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        progressbar.visibility = View.GONE
    }

    override fun onSuccess() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onFailed(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
