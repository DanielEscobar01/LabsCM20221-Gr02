package com.udea.mobilecomputation.labs20221_gr02.lab1

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isNotEmpty
import java.util.*


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
        val educationLevel: Spinner = findViewById(R.id.educational_level_input)
        val gender: RadioGroup = findViewById(R.id.gender_group)
        val date: DatePicker = findViewById(R.id.date_input)
        lateinit var radioButton: RadioButton


        button.setOnClickListener{
            if(name.text.isNotEmpty() && lastName.text.isNotEmpty() && date.isNotEmpty()) {
                val intent = Intent(this, ContactDataActivity::class.java)
                val birth_date: String
                val day = date.dayOfMonth
                val month = date.month
                val year = date.year
                val calendar: Calendar = Calendar.getInstance()
                val yearCurrent: Int = calendar.get(Calendar.YEAR)
                val monthCurrent: Int = calendar.get(Calendar.MONTH)
                val dayCurrent: Int = calendar.get(Calendar.DAY_OF_MONTH)

                if(year == yearCurrent && month== monthCurrent && day==dayCurrent){
                    showErrorDialog()
                }else {
                    birth_date = day.toString() + "/" + month.toString() + "/" + year.toString()
                    val selectedOption: Int = gender.checkedRadioButtonId
                    if(selectedOption != -1) {
                        radioButton = findViewById(selectedOption)
                        intent.putExtra("gender", radioButton.text)
                    }

                    intent.putExtra("name", name.text.toString())
                    intent.putExtra("last_name", lastName.text.toString())
                    intent.putExtra("date", birth_date)

                    intent.putExtra("education", educationLevel.selectedItem.toString())
                    startActivity(intent)
                }
            }else{
                showDialog()
            }
        }
    }

    private fun showDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialog)
        builder.setMessage(R.string.messagePersonalActivity)
        builder.setPositiveButton(R.string.positive, DialogInterface.OnClickListener{dialog, which ->
            Toast.makeText(this,"Positive Button Action", Toast.LENGTH_LONG).show()
        })
        builder.show()
    }

    private fun showErrorDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialog)
        builder.setMessage(R.string.messageErrorDate)
        builder.setPositiveButton(
            R.string.positive,
            DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "Positive Button Action", Toast.LENGTH_LONG).show()
            })
        builder.show()
    }
    }

