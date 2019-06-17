package com.mycompany.myapp.controller

import javafx.collections.ObservableList
import com.mycompany.myapp.utils.BaseController
import com.mycompany.myapp.model.User
import tornadofx.*
import tornadofx.EventBus.RunOn.*


object UserRequest : FXEvent(BackgroundThread)

class FetchUserEvent(val users:ObservableList<User>) : FXEvent()


class UserController : Controller() {

    init {

        subscribe<UserRequest> {
            val usersList = getAllUsers()
            fire(FetchUserEvent(usersList))
        }
    }
    val base: BaseController by inject()


    /**
     * GET getAccount
     */
    var API_ACCOUNT= base.BASE_URI+"account"

    /**
     * POST saveAccount
     */
    var API_ACCOUNT_SAVE= base.BASE_URI+"account"

    /**
     * POST changePassword
     */
    var API_ACCOUNT_CHANGE_PASSWORD= base.BASE_URI+"account/change-password"

    /**
     * POST finishPasswordReset
     */
    var API_ACCOUNT_RESET_FINISH= base.BASE_URI+"account/reset-password/finish"

    /**
     * POST requestPasswordReset
     */
    var API_ACCOUNT_RESET_INIT= base.BASE_URI+"account/reset-password/init"

    /**
     * GET activateAccount
     */
    var API_ACTIVATE= base.BASE_URI+"activate"

    /**
     * POST registerAccount
     */
    var API_REGISTER = base.BASE_URI+"register"

    /**
     * GET getActiveProfiles
     */
    var API_PROFILE_INFO = base.BASE_URI+"profile-info"

    /**
     * POST authorize
     * GET isAuthenticated
     */
    var API_USERS_AUTHENTICATE = base.BASE_URI+"authenticate"

    /**
     * GET getAllUsers
     * POST createUser
     * PUT updateUser
     * DELETE deleteUser
     */
    var API_USERS = base.BASE_URI+"users"

    /**
     * GET getAuthorities
     */
    var API_USERS_AUTHORITIES = base.BASE_URI+"users/authorities"

    /**
     * GET getUser
     * DELETE deleteUser
     */
    var API_USER= base.BASE_URI+"users/"//{login}

    fun createUser(user: User){
        base.api.post(API_USERS,user)
    }

    fun getAllUsers(): ObservableList<User> {
        return  base.api.get(API_USERS).list().toModel()
    }

    fun getUser(user : User): ObservableList<User> {
        return  base.api.get(API_USERS, user).list().toModel()
    }

    fun updateUser(user: User){
        base.api.put(API_USERS,user)
    }

    fun deleteUser(login: String){
        base.api.put(API_USER+"$login")
    }
}



