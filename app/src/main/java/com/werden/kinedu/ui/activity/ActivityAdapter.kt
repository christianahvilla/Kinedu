package com.werden.kinedu.ui.activity

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.werden.kinedu.R
import com.werden.kinedu.model.activity.Activity
import java.io.InputStream
import java.net.URL


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
        Picasso.with(context).load(activityList[position].thumbnail).resize(800, 800).into(holder.activity_image)
        holder.activity_title.text = activityList[position].name
        holder.activity_description.text = activityList[position].purpose
    }

    private fun getBmpImage(url: String):  Drawable{
        val `is` = URL(url).content as InputStream
        return Drawable.createFromStream(`is`, "src name")
    }



    class ActivityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val activity_image: ImageView = itemView.findViewById(R.id.activity_image)
        val activity_title: TextView = itemView.findViewById(R.id.activity_title)
        val activity_description: TextView = itemView.findViewById(R.id.activity_description)
    }


}