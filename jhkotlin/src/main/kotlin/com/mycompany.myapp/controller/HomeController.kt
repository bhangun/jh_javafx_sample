package com.mycompany.myapp.shared.home

import tornadofx.*

class HomeController : Controller() {

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
