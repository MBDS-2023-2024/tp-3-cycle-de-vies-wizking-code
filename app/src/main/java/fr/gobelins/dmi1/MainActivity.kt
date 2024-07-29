package fr.gobelins.dmi1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
        binding.btnHomeCall.setOnClickListener{
        //Check if CALL_PHONE permission is granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //Request CALL_PHONE permission
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
            } else {
            //Permission already granted, make the call
                val phoneIntent = Intent(Intent.ACTION_CALL).apply {
                 data = Uri.parse("tel:911")
                }
                startActivity(phoneIntent)
            }
        }

        binding.btnHomeSearch.setOnClickListener{
                // URL à ouvrir
                val url = "https://google.com"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
        }


        binding.btnHomePartagervia.setOnClickListener{
            val ContentMessage = "just share with you via code"
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, ContentMessage)
            }
            val chooser = Intent.createChooser(shareIntent, "Share message via")
            if (shareIntent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }
    }
}