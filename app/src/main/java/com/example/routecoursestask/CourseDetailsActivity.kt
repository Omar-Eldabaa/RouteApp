package com.example.routecoursestask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CourseDetailsActivity : AppCompatActivity() {
    lateinit var content : TextView
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)
        image =findViewById(R.id.image_view2)
        content = findViewById(R.id.content)
        content.text = intent?.getStringExtra("content")
        image.setImageResource(
                intent?.getIntExtra("image", R.drawable.android) ?: R.drawable.android
                )
    }
}