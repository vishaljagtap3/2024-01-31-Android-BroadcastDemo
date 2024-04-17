package `in`.bitcode.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBR : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context!!, intent!!.action, Toast.LENGTH_LONG).show()
        when {
            intent.action.equals(Intent.ACTION_BATTERY_LOW) ->
                Log.e("tag", "Battery is low...")

            intent.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED) -> {
                val isEnabled = intent.getBooleanExtra("state", false)
                val message = if(isEnabled) {
                    "Airplane mode is ON"
                }
                else {
                    "Airplane mode is OFF"
                }
                Log.e("tag", message)
            }

            intent.action.equals(Intent.ACTION_WALLPAPER_CHANGED) ->
                Log.e("tag", "Wallpaper changed!")

            intent.action.equals("in.bitcode.download.COMPLETE") ->
                Log.e("tag", "Got the downloaded data ${intent.getStringExtra("path")}")
        }
    }
}