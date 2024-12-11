package com.example.cs_topics_project_test

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: com.example.cs_topics_project_test.databinding.ActivitySignUpBinding
    private lateinit var firebaseAuth: com.google.firebase.auth.FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = com.example.cs_topics_project_test.databinding.ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance()

        binding.signInButton.setOnClickListener {
            startActivity(Intent(this, com.example.cs_topics_project_test.SignInActivity::class.java))

        }
        binding.signUpButton.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            // redirect to sign in page
                            startActivity(
                                Intent(
                                    this,
                                    com.example.cs_topics_project_test.SignInActivity::class.java
                                )
                            )

                        } else { // if sign in fails
                            Toast.makeText(this, "Authentication failed. ", Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()

            }
        }
    }
}