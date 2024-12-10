package com.example.cmspos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.cmspos.ui.theme.CMSPosTheme
import com.example.cmspos.view.LoginView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CMSPosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginView(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
