package `in`.bitcode.broadcastdemo

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import `in`.bitcode.broadcastdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var myBR: MyBR

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            myBR = MyBR()
            val intentFilter = IntentFilter()
            intentFilter.priority = 1000
            intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
            intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            intentFilter.addAction(Intent.ACTION_WALLPAPER_CHANGED)
            intentFilter.addAction("in.bitcode.download.COMPLETE")

            registerReceiver(
                myBR,
                intentFilter,
                RECEIVER_EXPORTED
            )
        }

        binding.btnUnRegister.setOnClickListener {
            unregisterReceiver(myBR)
        }
    }
}