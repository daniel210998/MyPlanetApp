package dev.example.myplanetapp.RegistroVoluntario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import androidx.navigation.findNavController
import dev.example.myplanetapp.R

class FragmentDatos2 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_datos2, container, false)
        view.findViewById<Button>(R.id.btnEnviar).setOnClickListener {
            view.findNavController().navigate(R.id.action_fragmentDatos2_to_fragmentDatos3) }
        return view
    }



}