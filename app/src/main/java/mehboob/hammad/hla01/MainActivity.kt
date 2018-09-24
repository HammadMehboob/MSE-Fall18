//@author: Hammad Mehboob
//coded on: 23.09.18 11.19.00

package com.example.android.logindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import org.w3c.dom.Text

import mehboob.hammad.hla01.R.layout.activity_main

class MainActivity : AppCompatActivity() {

    private var Name: EditText? = null
    private var Password: EditText? = null
    private var Info: TextView? = null
    private var Login: Button? = null
    private var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Name = findViewById(R.id.etName) as EditText
        Password = findViewById(R.id.etPassword) as EditText
        Info = findViewById(R.id.tvInfo) as TextView
        Login = findViewById(R.id.btnLogin) as Button

        Info!!.text = "No of attempts remaining: 5"

        Login!!.setOnClickListener { validate(Name!!.text.toString(), Password!!.text.toString()) }
    }

    private fun validate(userName: String, userPassword: String) {
        if (userName == "Admin" && userPassword == "1234") {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        } else {
            counter--

            Info!!.text = "No of attempts remaining: " + counter.toString()

            if (counter == 0) {
                Login!!.isEnabled = false
            }
        }
    }

}