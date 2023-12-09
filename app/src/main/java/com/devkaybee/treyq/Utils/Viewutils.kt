package com.devkaybee.treyq.Utils

import android.content.Context
import android.widget.Toast

class Viewutils {

    object  Extensions{
        fun Context.toast(message: String){
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}