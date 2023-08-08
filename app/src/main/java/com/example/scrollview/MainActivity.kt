package com.example.scrollview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var tvAbout:TextView
    lateinit var contactUs:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvAbout=findViewById(R.id.tvAbout)
        tvAbout.setOnClickListener {
            val intent=Intent(this,AboutUs::class.java)
            startActivity(intent)
        }

        contactUs=findViewById(R.id.contactUs)
        contactUs.setOnClickListener {
            val intent_two=Intent(this,ContactUs::class.java)
            startActivity(intent_two)
        }



    }
    fun careerAlert(view: View){
        val alertDialogBox:AlertDialog.Builder=AlertDialog.Builder(this)
        alertDialogBox.setTitle("Greeting_from_MarquisTech_HR")
        alertDialogBox.setMessage("Please share your CV/Resume on mqt@hr.com")
        alertDialogBox.setPositiveButton("Apply"){dialog,id ->}
        alertDialogBox.setNeutralButton("Cancel"){dialog,id ->}
        alertDialogBox.setCancelable(false)
        alertDialogBox.show()

    }
}