package dev.example.myplanetapp.events_timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
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
        val bottomHiddenText: TextView = view.findViewById(R.id.bottomHiddenText)
        btnApplyEvent.isVisible = true

        val strSponsor = "Quedan " + eventModel.spots.toString() + " lugares disponibles"

        eventTitle.text = eventModel.title
        eventTime.text = eventModel.time
        eventSponsor.text = eventModel.sponsor
        eventSpots.text = strSponsor

        val spotsAvaliable: Int = eventModel.spots!!

        if(spotsAvaliable > 0)
        {
            btnApplyEvent.isVisible = true
            eventSpots.visibility = View.VISIBLE
            bottomHiddenText.visibility = View.GONE
        }
        else
        {
            btnApplyEvent.isVisible = false
            eventSpots.visibility = View.GONE
            bottomHiddenText.visibility = View.VISIBLE
        }


        if(spotsAvaliable > 0)
        {
            btnApplyEvent.isVisible = true
            eventSpots.visibility = View.VISIBLE
            bottomHiddenText.visibility = View.GONE
        }
        else
        {
            btnApplyEvent.isVisible = false
            eventSpots.visibility = View.GONE
            bottomHiddenText.visibility = View.VISIBLE
        }


        btnApplyEvent.setOnClickListener {
            eventModel.spots = spotsAvaliable - 1
            db.collection("event")
                .document(docId)
                .update("spots", eventModel.spots)

            this.dismiss()
        }
    }
}