package dev.example.myplanetapp.RegistroVoluntario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
        return inflater.inflate(R.layout.fragment_datos2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val spnSexo = view.findViewById<Spinner>(R.id.spnSexo)
//        val spnDiscapacidad = view.findViewById<Spinner>(R.id.spnDiscapacidad)
//
//        //val listaSexo = listOf("Masculino","Femenino","Otro")
//        //val listaDiscapacidad = listOf("Sí tengo discapacidad","No tengo discapacidad")
//
//        val listaSexo = resources.getStringArray(R.array.Sexo)
//        val listaDiscapacidad = resources.getStringArray(R.array.Discapadidad)
//
//        spnSexo.adapter = ArrayAdapter(this.requireContext(), R.layout.support_simple_spinner_dropdown_item, listaSexo) as SpinnerAdapter


        val spinner: Spinner = view.findViewById(R.id.spnSexo)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.Sexo,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        view.findViewById<Button>(R.id.btnEnviar).setOnClickListener {
            view.findNavController().navigate(R.id.action_fragmentDatos2_to_fragmentDatos3) }
    }



}