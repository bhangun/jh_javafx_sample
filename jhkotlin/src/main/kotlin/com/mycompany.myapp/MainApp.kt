package com.mycompany.myapp


import com.mycompany.myapp.shared.styles.Styles
import com.mycompany.myapp.shared.login.LoginView
import tornadofx.*


class MainApp : App(LoginView::class, Styles::class)