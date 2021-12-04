package dev.example.myplanetapp.user_profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dev.example.myplanetapp.LoginActivity
import dev.example.myplanetapp.R
import dev.example.myplanetapp.UserMainActivity

class FragmentUserProfile : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username: TextView = view.findViewById(R.id.userName)
        val btnLogout: Button = view.findViewById(R.id.btnLogOutProfile)


        btnLogout.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        val user = Firebase.auth.currentUser
        if (user != null) {
            username.text = user.email
        } else {
            Log.i("AUTH", "No user authenticated")
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}