package com.ds2.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ds2.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener { calculateTip()}

    }

    fun calculateTip() {
        val costOfService = binding.editTextCostOfService.text.toString().toDouble()
        val selectedId = binding.radioGroupTipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.radioButton_amazingService -> 0.20
            R.id.radioButton_goodService -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * costOfService
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formatedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.txtTipAmount.text = formatedTip.toString()
    }
}