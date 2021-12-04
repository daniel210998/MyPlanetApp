package dev.example.myplanetapp.events_timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.firestore.FirebaseFirestore
import dev.example.myplanetapp.R
import dev.example.myplanetapp.model.VolunteeringEvent

class JoinToEvent(val eventModel: VolunteeringEvent, val docId: String) : BottomSheetDialogFragment()
{
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_join_to_event, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val eventTitle: TextView = view.findViewById(R.id.bottommEventTitle)
        val eventDescription: TextView = view.findViewById(R.id.bottomEventDescription)
        val eventPlace: TextView = view.findViewById(R.id.bottomEventPlace)
        val eventTime: TextView = view.findViewById(R.id.bottomEventTime)
        val eventSponsor: TextView = view.findViewById(R.id.bottomEventSponsor)
        val eventSpots: TextView = view.findViewById(R.id.bottomSpots)
        val btnApplyEvent: Button = view.findViewById(R.id.bottomBtnApplyToEvent)

        val strSponsor = "Quedan " + eventModel.spots.toString() + " lugares disponibles"

        eventTitle.text = eventModel.title
        eventTime.text = eventModel.time
        eventSponsor.text = eventModel.sponsor
        eventSpots.text = strSponsor

        btnApplyEvent.setOnClickListener {
            eventModel.spots = eventModel.spots!! - 1
            db.collection("event")
                .document(docId)
                .update("spots", eventModel.spots)
        }

    }
}