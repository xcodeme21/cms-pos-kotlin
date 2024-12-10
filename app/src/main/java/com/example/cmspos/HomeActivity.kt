package com.example.cmspos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cmspos.ui.theme.CMSPosTheme
import com.example.cmspos.view.DashboardScreen

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMSPosTheme {
                DashboardScreen()
            }
        }
    }
}