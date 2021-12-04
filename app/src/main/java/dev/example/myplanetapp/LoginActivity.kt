package dev.example.myplanetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottomNavLogin)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostLogin) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavView.setupWithNavController(navController)
    }
}