package com.mycompany.myapp.controller


import com.mycompany.myapp.view.RegisterView
import tornadofx.Controller

class RegisterController : Controller() {
    val registerView: RegisterView by inject()
val loginController: LoginController by inject()
    init{

    }
}