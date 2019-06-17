package com.mycompany.myapp.view

import com.mycompany.myapp.controller.FetchUserEvent
import com.mycompany.myapp.model.User
import com.mycompany.myapp.controller.UserController
import com.mycompany.myapp.controller.UserRequest
import com.mycompany.myapp.model.UserModel
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon.*
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.beans.binding.BooleanExpression
import tornadofx.*



class UserFragment : Fragment("User View") {
    val userView : UserList by inject()
    val userControl: UserController by inject()
    val userForm : UserForm by inject()
    val model : UserModel by inject()


    override val root = borderpane()
    init{
        log.info(" entity fragment")
        with(root) {
            center = userView.root
        }
    }
    /*borderpane {
        this.prefWidthProperty().bind(this@borderpane.widthProperty());
        this.prefHeightProperty().bind(this@borderpane.heightProperty());
    }*/


    override fun onSave() {
        log.info("save")

    }

    override fun onRefresh() {
        log.info("refresh-----------")
        //super.onRefresh()
    }

    override fun onCreate() {
        log.info("create-----------")
       // super.onCreate()
        //userForm.root.show()
                // userCreate.show()
       // workspace.dock(UserForm(),true)
        with(root) {
            center = userForm.root
        }
    }

    override fun onDelete() {
        log.info("delete-----------")
    }


}

class UserFragmentModel : ItemViewModel<UserFragment>() {
    val root = bind(UserFragment::root)
}

class UserForm : View("Register User") {
    val model : UserModel by inject()
    val userControl: UserController by inject()

    override val root = form {
        fieldset("User Information", FontAwesomeIconView(USER)) {
            field("First Name") {
                textfield(model.firstName).required()
            }
            field("Last Name") {
                textfield(model.lastName)
            }
            field("Login") {
                textfield(model.login)
            }
            field("Email") {
                textfield(model.email).required()
            }
            field("Image URL") {
                textfield(model.imageUrl)
            }
            field() {
                checkbox("Activated")
            }
            field("Authorities") {
                //combobox {  }(model.authorities)
            }
        }
        button("Save") {
            action {
                model.commit {
                    val user = model.item
                    /*Notifications.create()
                            .title("User saved!")
                            .text("${user.firstName} and ${user.email}")
                            .owner(this)
                            .showInformation()*/
                    userControl.createUser(user);
                }

            }
            enableWhen(model.valid)
        }
    }
}

class UserList : View() {
    val user: UserController by inject()

    override val root = pane {
        fire(UserRequest)
        //tableview(user.getAllUsers()) {
        tableview<User>() {
            column("ID", User::idProperty)
            column("Username", User::loginProperty)
            column("First Name", User::firstNameProperty)
            column("Last Name", User::lastNameProperty)
            column("Email", User::emailProperty)
            column("Activated", User::activatedProperty)
            column("Authorities", User::authoritiesProperty).contentWidth(padding = 100.0)

            subscribe<FetchUserEvent> { event ->
                items.setAll(event.users)
            }
        }
    }
}

