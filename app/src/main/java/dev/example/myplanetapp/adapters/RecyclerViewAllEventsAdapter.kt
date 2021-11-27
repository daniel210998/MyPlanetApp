package dev.example.myplanetapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import dev.example.myplanetapp.R
import dev.example.myplanetapp.model.VolunteeringEvent

class RecyclerViewAllEventsAdapter(options: FirestoreRecyclerOptions<VolunteeringEvent>) :
    FirestoreRecyclerAdapter<VolunteeringEvent, RecyclerViewAllEventsAdapter.ViewHolder>(options)
{

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val eventPicture: ImageView = itemView.findViewById(R.id.eventPicture)
        val eventTitle: TextView = itemView.findViewById(R.id.eventTitle)
        val eventTime: TextView = itemView.findViewById(R.id.eventTime)
        val eventSpots: TextView = itemView.findViewById(R.id.eventSpots)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.event_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: VolunteeringEvent) {
        holder.eventTitle.text = model.title
        holder.eventTime.text = model.time
        holder.eventSpots.text = model.spots.toString()

        val storageReference = FirebaseStorage.getInstance().reference.child(model.picture.toString())

        GlideApp.with(holder.itemView)
            .load(storageReference)
            .into(holder.eventPicture)
    }

}