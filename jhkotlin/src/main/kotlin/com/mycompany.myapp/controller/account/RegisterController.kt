package com.mycompany.myapp.shared.account


import com.mycompany.myapp.shared.login.LoginController
import tornadofx.Controller

class RegisterController : Controller() {
    val registerView: RegisterView by inject()
val loginController: LoginController by inject()
    init{

    }
}