package com.devkaybee.treyq.Onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.devkaybee.treyq.Authentication.LoginActivity
import com.devkaybee.treyq.Dashboard.DashboardActivity
import com.devkaybee.treyq.R
import com.devkaybee.treyq.Utils.Viewutils.Extensions.toast
import com.devkaybee.treyq.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var splashScreen: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen = ActivityMainBinding.inflate(layoutInflater)
        setContentView(splashScreen.root)

        val firebaseAuth = FirebaseAuth.getInstance()
        val firebaseUser = firebaseAuth.currentUser

        Handler(Looper.getMainLooper()).postDelayed({

            if(firebaseUser == null){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }
        },3000)

    }
}