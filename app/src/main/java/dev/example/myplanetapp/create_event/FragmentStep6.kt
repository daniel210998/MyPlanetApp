package dev.example.myplanetapp.create_event

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import dev.example.myplanetapp.R
import kotlin.collections.hashMapOf as hashMapOf
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentStep6.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentStep6 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
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
        return inflater.inflate(R.layout.fragment_step6, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonSaveStep6 = view.findViewById<Button>(R.id.btnSiguienteStep6)
        buttonSaveStep6.setOnClickListener {
            val size = 2
            val s = HashSet<Int>(size)
            while (s.size < size) {
                s += Random.nextInt(1,100)
            }
            val NombreEvento = FragmentStep1.globalNameEvent
            val Direccion = FragmentStep3.globalDirección
            val CantPerso = FragmentStep4.globalCantPersonas
            val HoraIni = FragmentStep4.globalHoraIni
            val dia = FragmentStep4.globalDia
            val mes = FragmentStep4.globalMes
            val anio = FragmentStep4.globalAnio
            val descripEvento = view.findViewById<EditText>(R.id.txtAcercaEventoPaso6).text.toString()
            //var lista1: List<String> = listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sábado", "domingo")
            val data : HashMap<String,Any> = hashMapOf(
                "id" to 6,
                "title" to NombreEvento,
                "time" to HoraIni,
                "spots" to CantPerso,
                "sponsor" to "Zucaritas",
                "day" to dia,
                "month" to mes,
                "year" to anio,
                "sponsor_logo" to "Logo Nuevo",
                "picture" to "Photo",
                "description" to descripEvento,
                "place" to Direccion,
                "selected" to false
            )
            db.collection("event")
                .add(data)
                .addOnSuccessListener { documentReference ->
                    Log.d(ContentValues.TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(ContentValues.TAG, "Error adding document", e)
                }
        }
    }

    companion object {
        var globalDescEvent = "";
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentStep6.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentStep6().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}