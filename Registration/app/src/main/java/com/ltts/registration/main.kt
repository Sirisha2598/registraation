package com.ltts.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class main: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2.setOnClickListener {
            Toast.makeText(this, "Login button clicked", Toast.LENGTH_LONG).show()
            var myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

    }
}
