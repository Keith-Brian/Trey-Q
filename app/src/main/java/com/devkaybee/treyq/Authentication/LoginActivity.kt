package com.devkaybee.treyq.Authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devkaybee.treyq.R
import com.devkaybee.treyq.Utils.Viewutils.Extensions.toast
import com.devkaybee.treyq.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var loginScreen: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginScreen = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginScreen.root)

        firebaseAuth = Firebase.auth

        loginScreen.loginBtn.setOnClickListener {

            if(!loginScreen.inputUsername.text.isEmpty() && !loginScreen.inputPassword.text.isEmpty() ){
                performSignIn()
            } else {
                toast("fields cannot be empty!")
            }
        }

    }

    // Created a  function to  login the user using email and password

    private fun performSignIn(){

        val email = loginScreen.inputUsername.text.toString()
        val password = loginScreen.inputPassword.text.toString()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    toast("Login Successful")
                }else{
                    toast("Login Failed!l")
                }
            }


    }
}