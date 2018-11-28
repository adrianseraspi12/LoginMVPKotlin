package com.codace.loginmvpkotlin.model

data class Credentials(val username: String,
                       val password: String) {

    fun isValid(): Boolean {
        return username == "kotlin" &&
                password == "pass"
    }

}