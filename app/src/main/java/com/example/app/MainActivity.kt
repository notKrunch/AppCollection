package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val totalbill = findViewById(R.id.totalbill) as EditText
        val taxes = findViewById(R.id.taxes) as EditText
        val tip = findViewById(R.id.tip) as EditText
        val howmanypeople = findViewById(R.id.howmanypeople) as EditText
        val calculate = findViewById(R.id.calculate) as Button
        val amountperperon = findViewById(R.id.billamountperperson) as TextView
        val reset = findViewById(R.id.reset) as Button
        var buttonOnClickActive = false

        calculate.setOnClickListener {
            if (totalbill.text.toString() == "" || taxes.text.toString() == "" || tip.text.toString() == "" || howmanypeople.text.toString() == "") {
                buttonOnClickActive = false
                Toast.makeText(
                    applicationContext,
                    "Enter values in all fields. Enter 0 if not required.",
                    Toast.LENGTH_LONG
                ).show()
            } else if (totalbill.text.toString() == "." || taxes.text.toString() == "." || tip.text.toString() == "." || howmanypeople.text.toString() == ".") {
                buttonOnClickActive = false

            } else {
                buttonOnClickActive = true
                val totalbillF = totalbill.text.toString().toFloat()
                val taxesF = taxes.text.toString().toFloat()
                val tipF = tip.text.toString().toFloat()
                val howmanypeopleF = howmanypeople.text.toString().toFloat()
                val finalBill =
                    ((totalbillF) + ((taxesF / 100) * totalbillF) + (tipF)) / (howmanypeopleF)
                amountperperon.text = "%.2f".format(finalBill)
            }
            reset.setOnClickListener{
                totalbill.setText("")
                taxes.setText("")
                tip.setText("")
                howmanypeople.setText("")
                amountperperon.text = ""
                totalbill.requestFocus()
            }

            }
        }
    }
