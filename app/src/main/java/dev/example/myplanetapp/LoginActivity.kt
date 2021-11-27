package dev.example.myplanetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import dev.example.myplanetapp.RegistroVoluntario.FragmentDatos3

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnFragment3 : Button = findViewById(R.id.btnSalir)
        btnFragment3.setOnClickListener {
            val salir = FragmentDatos3()
            val fragment : Fragment ? =
                supportFragmentManager.findFragmentByTag(FragmentDatos3::class.java.simpleName)

            if(fragment !is FragmentDatos3){
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, salir, FragmentDatos3::class.java.simpleName)
                    .commit()
            }
            btnFragment3.visibility = View.GONE
        }
    }
}