package dev.example.myplanetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class RegistroVoluntarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_voluntario)

        val spnSexo = findViewById<Spinner>(R.id.spnSexo)
        val spnDiscapacidad = findViewById<Spinner>(R.id.spnDiscapacidad)

        //val listaSexo = listOf("Masculino","Femenino","Otro")
        //val listaDiscapacidad = listOf("Sí tengo discapacidad","No tengo discapacidad")
        val listaSexo = resources.getStringArray(R.array.opciones)
        val listaDiscapacidad = resources.getStringArray(R.array.opciones)

        val adaptadorSexo = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaSexo)
        val adaptadorDiscapacidad = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaDiscapacidad)
        spnSexo.adapter = adaptadorSexo
        spnDiscapacidad.adapter = adaptadorDiscapacidad

    }
}