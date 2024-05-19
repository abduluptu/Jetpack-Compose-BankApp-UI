package com.soha.infotech.jetpack_compose_bankapp_ui.views.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.JetpackComposeBankAppUITheme
import com.soha.infotech.jetpack_compose_bankapp_ui.views.bottom_navigation.BottomNavigationBar
import com.soha.infotech.jetpack_compose_bankapp_ui.views.sections.CardSection
import com.soha.infotech.jetpack_compose_bankapp_ui.views.sections.CurrencySection
import com.soha.infotech.jetpack_compose_bankapp_ui.views.sections.FinanceSection
import com.soha.infotech.jetpack_compose_bankapp_ui.views.sections.WalletSection

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeBankAppUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    //Added new code here
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        HomeScreen()
                    }

                }
            }
        }
    }
}

/**
 * Step3: Create Home Screen
 */

@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Add sections here
            WalletSection()
            CardSection()
           // Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()
            CurrencySection()
        }
    }
}