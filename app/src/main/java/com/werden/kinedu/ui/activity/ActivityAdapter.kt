package com.werden.kinedu.ui.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.werden.kinedu.R
import com.werden.kinedu.model.activity.Activity
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation


class ActivityAdapter(private val context: Context,
                           private val activityList: MutableList<Activity>):
    RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_activity, parent, false)
        return ActivityViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        Picasso.get().load(activityList[position].thumbnail).fit().centerCrop().transform(RoundedCornersTransformation(10, 0)).into(holder.activity_image)
        holder.activity_title.text = activityList[position].name
        holder.activity_description.text = activityList[position].purpose
    }


    class ActivityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val activity_image: ImageView = itemView.findViewById(R.id.activity_image)
        val activity_title: TextView = itemView.findViewById(R.id.activity_title)
        val activity_description: TextView = itemView.findViewById(R.id.activity_description)
    }


}