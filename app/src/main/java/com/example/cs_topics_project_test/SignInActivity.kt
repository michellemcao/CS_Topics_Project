package com.example.cs_topics_project_test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: com.example.cs_topics_project_test.databinding.ActivitySignInBinding
    private lateinit var firebaseAuth: com.google.firebase.auth.FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shows activity_sign_in.xml page
        binding = com.example.cs_topics_project_test.databinding.ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance()

        // when signUpButton clicked, goes to SignUpActivity page
        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, com.example.cs_topics_project_test.SignUpActivity::class.java))

        }

       binding.signInButton.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        // (change MainActivity to the actual main page of the app later)
                        Toast.makeText(this, "Sign In Successful. ", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, com.example.cs_topics_project_test.MainActivity::class.java))
                    } else {
                        // if sign in fails, display message to user
                        Toast.makeText(this, "Authentication failed. ", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty fields not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }

   override fun onStart() {
        super.onStart()

       // check if user is signed in (not null), should go to main part of app (i don't have that so rn just stuck at sign in page)
        if(firebaseAuth.currentUser != null){
            startActivity(Intent(this, com.example.cs_topics_project_test.MainActivity::class.java))
        }
    }
}