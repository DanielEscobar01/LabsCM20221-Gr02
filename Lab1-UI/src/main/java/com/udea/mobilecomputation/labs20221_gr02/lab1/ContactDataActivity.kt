package com.udea.mobilecomputation.labs20221_gr02.lab1

import android.content.ContentValues.TAG
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isNotEmpty

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        saveContact()
    }

    private fun saveContact() {

        val button: Button = findViewById(R.id.button_next)
        val phone: EditText = findViewById(R.id.phone_input)
        val email: EditText = findViewById(R.id.mail_input)
        val country: Spinner = findViewById(R.id.country_input)
        val bundle = intent.extras
        val dataName = bundle?.getString("name")
        val dataLastName = bundle?.getString("last_name")
        val dataDate = bundle?.getString("date")
        val dataGender = bundle?.getString("gender")

        button.setOnClickListener {
            if (phone.text.isNotEmpty() && email.text.isNotEmpty() && country.isNotEmpty()) {
               // Log.i(TAG,"El telefono del usuario es: "+phone.text)
                Log.i(TAG, "El nombre del usuario es: $dataName")
                Log.i(TAG, "El apellido del usuario es: $dataLastName")
                Log.i(TAG, "El date del usuario es: $dataDate")
                Log.i(TAG, "El genero del usuario es: $dataGender")
            } else {
                showDialog()
            }
        }
    }

        private fun showDialog(){
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.dialog)
            builder.setMessage(R.string.messageContactActivity)
            builder.setPositiveButton(R.string.positive, DialogInterface.OnClickListener{ dialog, which ->
                Toast.makeText(this,"Positive Button Action", Toast.LENGTH_LONG).show()
            })
            builder.show()
        }



}