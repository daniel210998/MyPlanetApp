package dev.example.myplanetapp.RegistroVoluntario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import dev.example.myplanetapp.R

class FragmentDatos1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_datos1, container, false)
        view.findViewById<Button>(R.id.btnSiguiente).setOnClickListener {
            view.findNavController().navigate(R.id.action_fragmentDatos1_to_fragmentDatos2) }
        return view
    }


}
