package dev.example.myplanetapp.events_timeline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.example.myplanetapp.R
import dev.example.myplanetapp.adapters.RecyclerViewAllEventsAdapter
import dev.example.myplanetapp.model.VolunteeringEvent
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference






class FragmentAllEvents : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvEvent: RecyclerView = view.findViewById(R.id.rv_allEvents)
        rvEvent.layoutManager = LinearLayoutManager(activity)
        val l = listVolunteeringEvent()
        rvEvent.adapter = RecyclerViewAllEventsAdapter(l)
    }

    private fun retrieveVolunteeringEvent() : List<VolunteeringEvent>
    {
        val lstEV: ArrayList<VolunteeringEvent> = ArrayList()

        val db = FirebaseFirestore.getInstance()

        val storageRef = FirebaseStorage.getInstance().reference
        var playaRef = storageRef.child("img_events/playa.jpg")

        val ONE_MEGABYTE: Long = 1024 * 1024
        playaRef.getBytes(ONE_MEGABYTE).addOnSuccessListener {
            // Data for "images/island.jpg" is returned, use this as needed
        }.addOnFailureListener {
            // Handle any errors
        }

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }



        return lstEV
    }

    private fun listVolunteeringEvent(): List<VolunteeringEvent>
    {
        val lstEV: ArrayList<VolunteeringEvent> = ArrayList()
        lstEV.add(VolunteeringEvent(1, "Produce Give Away","3:00 pm", 14, R.drawable.playa ))
        lstEV.add(VolunteeringEvent(2, "Limpieza de playas","12:00 am", 14, R.drawable.pasco ))
        lstEV.add(VolunteeringEvent(3, "Limpieza de playas","3:00 pm", 14, R.drawable.playa ))

        return lstEV
    }
}