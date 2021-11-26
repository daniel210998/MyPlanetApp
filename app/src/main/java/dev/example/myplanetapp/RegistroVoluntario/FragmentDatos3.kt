package dev.example.myplanetapp.RegistroVoluntario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import dev.example.myplanetapp.LoginActivity
import dev.example.myplanetapp.R
import android.content.Intent

class FragmentDatos3 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datos3, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent(activity, LoginActivity::class.java)
        requireActivity().startActivity(intent)

//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)

    }

}
