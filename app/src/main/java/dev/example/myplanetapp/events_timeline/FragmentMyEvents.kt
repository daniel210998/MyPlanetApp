package dev.example.myplanetapp.events_timeline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import dev.example.myplanetapp.R
import dev.example.myplanetapp.adapters.RecyclerViewAllEventsAdapter
import dev.example.myplanetapp.model.VolunteeringEvent

class FragmentMyEvents : Fragment() {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = db.collection("event")

    var eventAdapter: RecyclerViewAllEventsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //filter the items before passing to the recycler view
        val query: Query = collectionReference.whereEqualTo("selected", true)
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<VolunteeringEvent> = FirestoreRecyclerOptions.Builder<VolunteeringEvent>()
            .setQuery(query, VolunteeringEvent::class.java)
            .build()

        eventAdapter = RecyclerViewAllEventsAdapter(firestoreRecyclerOptions)

        val rvEvent: RecyclerView = view.findViewById(R.id.rvMyEvents)
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