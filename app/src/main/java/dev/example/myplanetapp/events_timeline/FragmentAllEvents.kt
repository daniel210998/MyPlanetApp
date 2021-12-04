package dev.example.myplanetapp.events_timeline

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentChange
import dev.example.myplanetapp.R
import dev.example.myplanetapp.adapters.RecyclerViewAllEventsAdapter
import dev.example.myplanetapp.model.VolunteeringEvent
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dev.example.myplanetapp.UserMainActivity


class FragmentAllEvents : Fragment() {

    private val db:FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference:CollectionReference = db.collection("event")

    var eventAdapter: RecyclerViewAllEventsAdapter? = null

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

        val query: Query = collectionReference.orderBy("id", Query.Direction.ASCENDING)
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<VolunteeringEvent> = FirestoreRecyclerOptions.Builder<VolunteeringEvent>()
            .setQuery(query, VolunteeringEvent::class.java)
            .build()

        eventAdapter = RecyclerViewAllEventsAdapter(firestoreRecyclerOptions)

        val rvEvent: RecyclerView = view.findViewById(R.id.rv_allEvents)
        rvEvent.layoutManager = LinearLayoutManager(activity)
        rvEvent.adapter = eventAdapter
    }

    override fun onStart() {
        super.onStart()
        eventAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        eventAdapter!!.stopListening()
    }
}