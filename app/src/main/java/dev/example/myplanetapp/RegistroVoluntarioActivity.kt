package dev.example.myplanetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.firebase.firestore.FirebaseFirestore
//import dev.example.myplanetapp.databinding.ActivityRegistroVoluntarioBinding
import java.util.*

class RegistroVoluntarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_voluntario)
//        setSupportActionBar(toolbar3)

        //activity_registro_voluntario
        val txtNombre: EditText = findViewById(R.id.txtNombre)
        val txtDireccion: EditText = findViewById(R.id.txtDireccion)
        val txtNumero: EditText = findViewById(R.id.txtNumero)
        val txtFecha: EditText = findViewById(R.id.txtFecha)
        val txtPais: EditText = findViewById(R.id.txtPais)
        val txtDocumento: EditText = findViewById(R.id.txtDocumento)
        val txtEmail: EditText = findViewById(R.id.txtEmail)
        val txtPassword: EditText = findViewById(R.id.txtPassword)
        val btnEnviar: Button = findViewById(R.id.btnEnviar)
        val db = FirebaseFirestore.getInstance()

        btnEnviar.setOnClickListener {
            val registro  = hashMapOf(
                "Nombre Completo" to txtNombre.text.toString(),
                "Direccion" to txtDireccion.text.toString(),
                "Celular" to txtNumero.text.toString(),
                "Fecha" to txtFecha.text.toString(),
                "Pais" to txtPais.text.toString(),
                "DNI" to txtDocumento.text.toString(),
                "Email" to txtEmail.text.toString(),
                "Password" to txtPassword.text.toString()
            )

            db.collection("Registro")
                .add(registro)
                .addOnSuccessListener {  documentReference ->
                    Toast.makeText(this,"Registro exitoso",Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener{e->
                    Toast.makeText(this,"Registro no exitoso",Toast.LENGTH_LONG).show()
                }
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }



//        mBinding = ActivityRegistroVoluntarioBinding.inflate(layoutInflater)
//        setContentView(mBinding.root)
//
//        val aaspnSexo=ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item)
//        aaspnSexo.addAll(Arrays.asList("Masculino","Femenino", "Otros"))

//        mBinding.spnSexo.adapter = aaspnSexo

//        val spnSexo = findViewById<Spinner>(R.id.spnSexo)
//        val spnDiscapacidad = findViewById<Spinner>(R.id.spnDiscapacidad)
//
////        val listaSexo = listOf("Masculino","Femenino","Otro")
////        val listaDiscapacidad = listOf("Sí tengo discapacidad","No tengo discapacidad")
//        val listaSexo = resources.getStringArray(R.array.Sexo)
//        val listaDiscapacidad = resources.getStringArray(R.array.Discapadidad)
//
//        val adaptadorSexo = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaSexo)
//        val adaptadorDiscapacidad = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaDiscapacidad)
//        spnSexo.adapter = adaptadorSexo
//        spnDiscapacidad.adapter = adaptadorDiscapacidad

    }


}