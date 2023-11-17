package com.example.courierpush

import android.app.Application
import com.courier.android.Courier
import com.courier.android.modules.signIn
import com.courier.android.modules.signOut
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // initialize Courier
        Courier.initialize(this)

        // Sign in to Courier.
        CoroutineScope(Dispatchers.Main).launch {
            Courier.shared.signOut()
            Courier.shared.signIn(
                accessToken = "<COURIER_API_KEY>",
                userId = "<COURIER_USER_ID>"
            )
        }
    }
}
