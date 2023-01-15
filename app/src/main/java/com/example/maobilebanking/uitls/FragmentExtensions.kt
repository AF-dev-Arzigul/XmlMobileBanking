package com.example.maobilebanking.uitls

import androidx.fragment.app.Fragment
import com.tapadoo.alerter.Alert
import com.tapadoo.alerter.Alerter

fun Fragment.alerterDefault(message:String){
    Alerter.create(requireActivity())
        .setText(message)
        .show()


}

