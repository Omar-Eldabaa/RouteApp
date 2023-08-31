package com.example.routecoursestask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.zip.Inflater

class RouteCoursesAdapter(val DataItem : ArrayList<CoursesData>) : RecyclerView.Adapter<RouteCoursesAdapter.RouteViewHolder>() {

    var onClicked : onClickListener? = null

    class RouteViewHolder (view:View) :ViewHolder (view) {
        val coursesImage:ImageView = view.findViewById(R.id.courses_image)
        val coursesButton: Button = view.findViewById(R.id.courses_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): RouteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.courses_item ,parent ,false)
        return RouteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return DataItem.size
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val item = DataItem.get(position)
        holder.coursesButton.setText(item.courseName)
        holder.coursesImage.setImageResource(item.image ?:R.drawable.android)
        holder.itemView.setOnClickListener(){
            onClicked?.onCourseClick(item)
        }
    }
}