package dev.example.myplanetapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.example.myplanetapp.R
import dev.example.myplanetapp.model.VolunteeringEvent

class RecyclerViewAllEventsAdapter(private var lstEvt: List<VolunteeringEvent>) : RecyclerView.Adapter<RecyclerViewAllEventsAdapter.ViewHolder>()
{

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val eventPicture: ImageView = itemView.findViewById(R.id.eventPicture)
        val eventTitle: TextView = itemView.findViewById(R.id.eventTitle)
        val eventTime: TextView = itemView.findViewById(R.id.eventTime)
        val eventSpots: TextView = itemView.findViewById(R.id.eventSpots)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAllEventsAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.event_card, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewAllEventsAdapter.ViewHolder, position: Int) {
        val itemRow = lstEvt[position]
        holder.eventTitle.text = itemRow.title
        holder.eventTime.text = itemRow.time
        holder.eventSpots.text = itemRow.spots.toString()
        holder.eventPicture.setImageResource(itemRow.picture)
    }

    override fun getItemCount(): Int {
        return lstEvt.size
    }

}