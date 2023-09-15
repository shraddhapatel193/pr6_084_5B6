package com.example.pr6_084_5b6

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class myservice : Service() {
    lateinit var mediaPlayer: MediaPlayer

    var TAG = "myservice"

    override fun onBind(intent:Intent): IBinder{
        TODO("Return the communication channel to the service")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if(!this::mediaPlayer.isInitialized)
            mediaPlayer = MediaPlayer.create(this,R.raw.song)
        if(intent!=null){
            val str1 : String? =  intent.getStringExtra("service1")
            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
            }
            else{
                mediaPlayer.pause()
                Log.i(TAG,"onStratCommand: ")
            }
        }
        else{
            mediaPlayer.start()}
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }

}