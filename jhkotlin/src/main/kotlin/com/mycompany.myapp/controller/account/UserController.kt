package com.mycompany.myapp.shared.account

import javafx.collections.ObservableList
import com.mycompany.myapp.shared.BaseController
import tornadofx.*

class UserController : Controller() {

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

    fun createUsers(users: User){
        base.api.post(API_USERS,users)
    }

    fun getAllUsers(): ObservableList<User> {
        return  base.api.get(API_USERS).list().toModel()
    }

    fun getUsers(user : User): ObservableList<User> {
        return  base.api.get(API_USERS, user).list().toModel()
    }

    fun updateUsers(users: User){
        base.api.put(API_USERS,users)
    }

    fun deleteUser(login: String){
        base.api.put(API_USER+"$login")
    }
}


