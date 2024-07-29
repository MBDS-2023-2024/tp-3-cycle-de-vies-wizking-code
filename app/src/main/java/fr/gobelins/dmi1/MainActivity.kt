package fr.gobelins.dmi1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.gobelins.dmi1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnHomeCompute.setOnClickListener{
            val intent = Intent(this, ComputeActivity::class.java)
            intent.extras?.putString("operation", "ADD")
            startActivity(intent)
        }
    }
}