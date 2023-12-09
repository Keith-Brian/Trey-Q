package com.devkaybee.treyq.Dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devkaybee.treyq.R
import com.devkaybee.treyq.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var  dashboardScreen: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardScreen = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashboardScreen.root)


    }
}