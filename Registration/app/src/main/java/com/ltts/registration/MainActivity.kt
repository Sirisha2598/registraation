package com.ltts.registration
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            var un = editTextTextPersonName2.text
            var pwd = editTextTextPersonName3.text
            if (TextUtils.isEmpty(un)) {
                Toast.makeText(this, " Username", Toast.LENGTH_LONG).show()
            } else if (TextUtils.isEmpty(pwd)) {
                Toast.makeText(this, " Password", Toast.LENGTH_LONG).show()
            } else {
                if (un.toString().equals("L&T") && pwd.toString().equals("Sirisha@12")) {
                    var i = Intent(this, main::class.java)
                    startActivity(i)
                } else {
                    var r = Intent(this, MainActivity::class.java)
                    startActivity(r)
                }
            }
        }
    }
}