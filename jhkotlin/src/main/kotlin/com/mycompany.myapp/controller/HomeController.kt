package com.mycompany.myapp.controller

import com.mycompany.myapp.view.UserFragment
import com.mycompany.myapp.view.administration.ConfigurationFragment
import com.mycompany.myapp.view.administration.HealthFragment
import com.mycompany.myapp.view.administration.MetricFragment
import com.mycompany.myapp.view.DashboardFragment
import tornadofx.*

class HomeController : Controller() {

    object HomeEvent : FXEvent(EventBus.RunOn.BackgroundThread)

    init{

    }

    fun dashboard(): DashboardFragment {
        return DashboardFragment()
    }

    fun newEntity(): UserFragment {
        return UserFragment()
    }

    fun userManagement(): UserFragment {
        return UserFragment()
    }

    fun metric(): MetricFragment {
        return MetricFragment()
    }
    fun health(): HealthFragment {
        return HealthFragment()
    }
    fun configuration(): ConfigurationFragment {
        return ConfigurationFragment()
    }
}
