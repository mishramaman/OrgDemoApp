package com.example.scrollview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class FirebaseActivity : AppCompatActivity() {
 lateinit var edtEmail:TextInputEditText
 lateinit var edtPassword:TextInputEditText
 lateinit var signIn:Button
 lateinit var tvRegister:TextView
 var firebaseAuth:FirebaseAuth= FirebaseAuth.getInstance()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)

        edtEmail=findViewById(R.id.edtEmail)
        edtPassword=findViewById(R.id.edtpassword)
        signIn=findViewById(R.id.SignIn)
        tvRegister=findViewById(R.id.tvRegister)

        tvRegister.setOnClickListener {
            val intent=Intent(this,signUp::class.java)
            startActivity(intent)
        }

        signIn.setOnClickListener {
            var email:String?=null
            var password:String?=null
            email=(edtEmail.text.toString())
            password=(edtPassword.text.toString())

            if(TextUtils.isEmpty(email)){
                Toast.makeText(this,"Enter email",Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(password)){
                Toast.makeText(this,"Enter Password",Toast.LENGTH_SHORT).show()
            }

            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                task->

                if(task.isSuccessful){
                    Toast.makeText(this,"LoginSuccessful",Toast.LENGTH_SHORT).show()
                    val intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }else{
                    Toast.makeText(this,"Authentication Failed",Toast.LENGTH_SHORT).show()
                }

            }


        }


    }

}