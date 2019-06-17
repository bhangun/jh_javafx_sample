package com.mycompany.myapp



import com.mycompany.myapp.styles.DefaultStyles
import com.mycompany.myapp.view.LoginView
import tornadofx.*


class MainApp : App(LoginView::class, DefaultStyles::class)