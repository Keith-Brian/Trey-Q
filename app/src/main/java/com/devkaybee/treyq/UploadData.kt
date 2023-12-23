package com.devkaybee.treyq

import androidx.lifecycle.MutableLiveData
import java.time.temporal.Temporal

data class UploadData(

    var temp: MutableLiveData<String>?=null,
    var ph:  MutableLiveData<String>?=null,
    var turbidity:  MutableLiveData<String>?=null,
    var status:  MutableLiveData<String>?=null,

    var date:  MutableLiveData<String>?=null,
    var time:  MutableLiveData<String>?=null
)
