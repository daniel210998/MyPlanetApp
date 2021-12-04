package dev.example.myplanetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.example.myplanetapp.RegistroVoluntario.FragmentDatos3
import dev.example.myplanetapp.LoginActivity as LoginActivity1

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        val navController = findNavController(R.id.fragment)

//        val BtnOpenFragment: Button = findViewById(R.id.btnCreateV)
//        BtnOpenFragment.setOnClickListener {
//            val LoginActivity = LoginActivity1()
//            val fragment : Fragment? =
//                supportFragmentManager.findFragmentByTag(LoginActivity::class.java.simpleName)
//
//            if(fragment !is LoginActivity1){
//                supportFragmentManager.beginTransaction()
//                    .add(R.id., LoginActivity, LoginActivity::class.java.simpleName)
//
//            }
//            BtnOpenFragment.visibility = View.GONE
//        }

//        val btnFragment3 : Button = findViewById(R.id.btnSalir)
//        btnFragment3.setOnClickListener {
//            val salir = FragmentDatos3()
//            val fragment : Fragment ? =
//                supportFragmentManager.findFragmentByTag(FragmentDatos3::class.java.simpleName)
//
//            if(fragment !is FragmentDatos3){
//                supportFragmentManager.beginTransaction()
//                    .add(R.id.container, salir, FragmentDatos3::class.java.simpleName)
//                    .commit()
//            }
//            btnFragment3.visibility = View.GONE
//
//        }
    }

}