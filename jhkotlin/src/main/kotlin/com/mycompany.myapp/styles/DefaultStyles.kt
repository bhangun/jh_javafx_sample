package com.mycompany.myapp.styles

import javafx.scene.text.FontWeight
import tornadofx.*

class DefaultStyles : Stylesheet() {
    companion object {
        val baseStyle by cssclass()
        val heading by cssclass()
        val zip by cssclass()
    }

    init {

        s(baseStyle) {
           // baseColor = Color.BISQUE
            padding = box(10.px)
        }

        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }

        select(form) {
            padding = box(25.px)
            prefWidth = 350.px

            s(zip) {
                maxWidth = 60.px
                minWidth = maxWidth
            }
        }
    }
}