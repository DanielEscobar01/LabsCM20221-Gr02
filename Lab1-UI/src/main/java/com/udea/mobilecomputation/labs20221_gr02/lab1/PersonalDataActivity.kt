package com.udea.mobilecomputation.labs20221_gr02.lab1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        goToContactActivity()
    }

    private fun goToContactActivity() {

        val button:Button = findViewById(R.id.button_next)
        val name:EditText = findViewById(R.id.name_input)
        val lastName: EditText = findViewById(R.id.last_name_input)
        val date: DatePicker = findViewById(R.id.date_input)
        button.setOnClickListener{
            if(name.text.isNotEmpty() && lastName.text.isNotEmpty()) {
                val intent = Intent(this, ContactDataActivity::class.java)
                startActivity(intent)
            }else{
                showDialog()
            }
        }
    }

    private fun showDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialog)
        builder.setMessage(R.string.message)
        builder.setPositiveButton(R.string.positive, DialogInterface.OnClickListener{dialog, which ->
            Toast.makeText(this,"Positive Button Action", Toast.LENGTH_LONG).show()
        })
        builder.show()
    }
}