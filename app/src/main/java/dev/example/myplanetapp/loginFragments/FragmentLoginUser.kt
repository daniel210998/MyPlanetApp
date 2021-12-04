package dev.example.myplanetapp.loginFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import dev.example.myplanetapp.R
import com.google.firebase.auth.FirebaseAuth
import dev.example.myplanetapp.RegistroVoluntarioActivity
import dev.example.myplanetapp.UserMainActivity

class FragmentLoginUser : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtEmail: EditText = view.findViewById(R.id.userEmail)
        val txtPassword: EditText = view.findViewById(R.id.userPassword)
        val btnLogin: Button = view.findViewById(R.id.btnUserLogin)
        val btnRegister: TextView = view.findViewById(R.id.btnUserRegister)

        val db = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener{
            var email: String = txtEmail.text.toString()
            var password: String = txtPassword.text.toString()

            if(email.isEmpty() and password.isEmpty())
            {
                Toast.makeText(activity, "Debe llenar los campos", Toast.LENGTH_LONG).show()
            }
            else
            {
                db.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {task ->
                        if (task.isSuccessful){
                            Toast.makeText(activity, "Inicio de sesión satisfactorio", Toast.LENGTH_LONG).show()
                            //startActivity(Intent(this,MainActivity::class.java))
                            startActivity(Intent(activity, UserMainActivity::class.java))
                        }else{
                            Toast.makeText(activity, "El correo y/o clave es incorrecto", Toast.LENGTH_LONG).show()
                        }

                    }
            }
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(activity, RegistroVoluntarioActivity::class.java))
        }
    }
}