package com.example.scrollview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class signUp : AppCompatActivity() {
    lateinit var tvLogin:TextView
    lateinit var edtEmailreg:TextInputEditText
    lateinit var edtpasswordreg:TextInputEditText
    lateinit var BtnSignUP:Button
    private val firebaseAuth=FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        tvLogin=findViewById(R.id.tvLogin)
        edtEmailreg=findViewById(R.id.edtEmailreg)
        edtpasswordreg=findViewById(R.id.edtpasswordreg)
        BtnSignUP=findViewById(R.id.BtnSignUP)


        tvLogin.setOnClickListener {
            val intent=Intent(this,FirebaseActivity::class.java)
            startActivity(intent)
            finish()
        }

        BtnSignUP.setOnClickListener {
            var email:String?=null
            var password:String?=null
            email=(edtEmailreg.text.toString())
            password=(edtpasswordreg.text.toString())

            if(TextUtils.isEmpty(email)){
                Toast.makeText(this,"Enter email", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(password)){
                Toast.makeText(this,"Enter Password", Toast.LENGTH_SHORT).show()
            }

            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                task ->

                if(task.isSuccessful){
                    Toast.makeText(this,"Registration Done",Toast.LENGTH_SHORT).show()
                    val intent=Intent(this,FirebaseActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this,"Enter valid E-mail id and password",Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}