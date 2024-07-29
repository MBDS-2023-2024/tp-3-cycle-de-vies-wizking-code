package fr.gobelins.dmi1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.gobelins.dmi1.databinding.ActivityMainBinding
import fr.gobelins.dmi1.databinding.ComputeActivityBinding

class ComputeActivity : AppCompatActivity() {
    private  lateinit var binding: ComputeActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ComputeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val operation = intent.getStringExtra("operation") ?: "ADD"
        binding.btnCompute.setOnClickListener {
           add()
        }
    }

    private fun add(){
        val firstValue = binding.firstOperand.text.toString()
        val secondValue = binding.secondOperand.text.toString()

        if (!firstValue.isNullOrEmpty() && !secondValue.isNullOrEmpty()) {
            val resultOperand = firstValue.toBigDecimal() + secondValue.toBigDecimal()
             binding.txtResult.text = resultOperand.toString()
        } else {
            Toast.makeText(this ,"Veuillez entrer des nombres", Toast.LENGTH_LONG).show()
        }
    }
}