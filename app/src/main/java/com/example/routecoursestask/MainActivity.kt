package com.example.routecoursestask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recycler :RecyclerView
    lateinit var adapter: RouteCoursesAdapter
    lateinit var data : ArrayList<CoursesData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler =findViewById(R.id.RecyclerView)
        initializeData()
        adapter = RouteCoursesAdapter(data)
        adapter.onClicked = object : onClickListener {
            override fun onCourseClick( data: CoursesData ) {
                val intent = Intent(this@MainActivity, CourseDetailsActivity::class.java)
                intent.putExtra("content", data.courseContent)
                intent.putExtra("image", data.image)
                startActivity(intent)
            }

        }
        recycler.adapter =adapter

    }
    fun initializeData () {
        data = ArrayList()
        data.add(CoursesData(1,"Android Development" ,R.drawable.android ,getString(R.string.Android_Content) ))
        data.add(CoursesData(2,"ios Development" ,R.drawable.ios ,getString(R.string.ios_content) ))
        data.add(CoursesData(3,"Full-Stack Development" ,R.drawable.fullstack , getString(R.string.Full_Stack_Content)  ))
    }
}