package dev.example.myplanetapp.create_event
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import dev.example.myplanetapp.R
import com.google.firebase.firestore.FirebaseFirestore
import android.content.Intent


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentStep1.newInstance] factory method to
 * create an instance of this fragment.
 */
public class FragmentStep1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //var evento01: Evento
    //    get() = Evento( id, title =  ,day = 0,
    //        sponsor = "", sponsor_logo = "",spots = 0, time = "")
    //    set(value) {value}

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_step1, container, false)
        return inflater.inflate(R.layout.fragment_step1, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnSiguienteStep1).setOnClickListener{view.findNavController().navigate(R.id.action_fragmentStep1_to_fragmentStep2)}
        view.findViewById<Button>(R.id.btnAgregarCampaniaPaso1).setOnClickListener{view.findNavController().navigate(R.id.action_fragmentStep1_to_fragmentStep1Campaign)}
        view.findViewById<Button>(R.id.btnAgregarCoHostPaso1).setOnClickListener{view.findNavController().navigate(R.id.action_fragmentStep1_to_fragmentStep1CoHost)}
        globalNameEvent = view.findViewById<EditText>(R.id.txtNombreEventoPaso1).text.toString()



        // Prueba
        //evento01.title =
        // Add a new document with a generated id.


    }

    // Test Parsing Data
    companion object {
        var globalNameEvent = "";
        @JvmStatic
        fun newInstance(isMyBoolean: Boolean) = FragmentStep1().apply {
            arguments = Bundle().apply {
                putBoolean("REPLACE WITH A STRING CONSTANT", isMyBoolean)
            }
        }
    }
}


