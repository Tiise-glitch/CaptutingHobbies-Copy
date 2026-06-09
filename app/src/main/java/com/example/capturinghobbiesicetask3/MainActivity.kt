package com.example.capturinghobbiesicetask3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var txtName : EditText
    lateinit var txtSurname : EditText
    lateinit var txtAge : EditText
    lateinit var rgGroup : RadioGroup
    lateinit var rbFemale : RadioButton
    lateinit var rbMale : RadioButton
    lateinit var chMusic : CheckBox
    lateinit var chSports : CheckBox
    lateinit var chReading: CheckBox
    lateinit var chTravel: CheckBox
    lateinit var btnSubmit: Button
    lateinit var btnClear: Button
    lateinit var txtOutput: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnClear = findViewById(R.id.btnClear)
        btnSubmit = findViewById(R.id.btnSubmit)
        txtName = findViewById(R.id.txtName)
        txtSurname = findViewById(R.id.txtSurname)
        txtAge = findViewById(R.id.txtAge)
        rgGroup = findViewById(R.id.rgRadioButton)
        rbFemale = findViewById(R.id.rbFemale)
        rbMale = findViewById(R.id.rbMale)
        chMusic = findViewById(R.id.chMusic)
        chSports = findViewById(R.id.chSports)
        chReading = findViewById(R.id.chReading)
        chTravel = findViewById(R.id.chTravel)
        txtOutput = findViewById(R.id.txtOutput)

        btnSubmit.setOnClickListener {
            val name = txtName.text.toString()
            val surname = txtSurname.text.toString()
            val age = txtAge.text.toString()

            val gender = when (rgGroup.checkedRadioButtonId){
                rbFemale.id -> "Female"
                rbMale.id -> "Male"
                else -> "Not specified"
            }
            val hobbiesBuilder = StringBuilder()
            if (chMusic.isChecked)
                hobbiesBuilder.append("Music, ")
            if (chSports.isChecked)
                hobbiesBuilder.append("Sports, ")
            if (chTravel.isChecked)
                hobbiesBuilder.append("Travel, ")
            if (chReading.isChecked)
                hobbiesBuilder.append("Reading, ")

            val hobbies = hobbiesBuilder.toString()

            val result = StringBuilder()
            result.append("Search Results:\n")
            result.append("Name: ").append(name).append("\n")
            result.append("Surname: ").append(surname).append("\n")
            result.append("Age: ").append(age).append("\n")
            result.append("Gender: ").append(gender).append("\n")
            result.append("Hobbies: ").append(hobbies)

            txtOutput.text = result.toString()


        }

        btnClear.setOnClickListener{
            txtName.text.clear()
            txtSurname.text.clear()
            txtAge.text.clear()
            rgGroup.clearCheck()
            chMusic.isChecked = false
            chSports.isChecked = false
            chTravel.isChecked = false
            chReading.isChecked = false
            txtOutput.text =" "


        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}