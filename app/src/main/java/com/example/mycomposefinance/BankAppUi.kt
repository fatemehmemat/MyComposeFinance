package com.example.mycomposefinance

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposefinance.bank_app_ui.sections.CardsSection
import com.example.mycomposefinance.bank_app_ui.sections.CurrenciesSection
import com.example.mycomposefinance.bank_app_ui.sections.FinanceSection
import com.example.mycomposefinance.bank_app_ui.sections.WalletSection
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable

fun BankUi(context: Context) {
    SetStatusColor(color = MaterialTheme.colorScheme.background)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen(context)
    }
}


@Composable
fun SetStatusColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color = color)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(context: Context) {
    Scaffold(bottomBar = {
        BottomNavigation {
            Toast.makeText(context,"$it", Toast.LENGTH_SHORT).show()
        }
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            WalletSection()
            CardsSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()
            CurrenciesSection()
        }
    }
}