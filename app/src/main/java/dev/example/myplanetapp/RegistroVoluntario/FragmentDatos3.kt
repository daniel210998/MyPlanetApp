//package dev.example.myplanetapp.RegistroVoluntario
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import com.google.firebase.firestore.FirebaseFirestore
//import dev.example.myplanetapp.R
//import android.content.Intent
//import dev.example.myplanetapp.databinding.FragmentDatos3Binding
//
//class FragmentDatos3 : Fragment() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val bind = FragmentDatos3Binding.inflate(layoutInflater)
//        bind.btnSalir.setOnClickListener {
//            val intent = Intent(this@FragmentDatos3.requireContext(), LoginActivity::class.java)
//            startActivity(intent)
//
//
//        }
//        // Inflate the layout for this fragment
//        return bind.root
//        //return inflater.inflate(R.layout.fragment_datos3, container, false)
//
//
//    }
//
//
//
////        val intent = Intent(this, LoginActivity::class.java)
////        startActivity(intent)
//
//
//
//}
