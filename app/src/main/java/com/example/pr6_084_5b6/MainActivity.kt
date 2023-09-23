package com.example.pr6_084_5b6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var togglePlaybtn = true
    var TAG ="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var playbtn = findViewById<FloatingActionButton>(R.id.play)
        var stopbtn = findViewById<FloatingActionButton>(R.id.stop)
        playbtn.setOnClickListener{
            Intent(applicationContext,myservice::class.java).putExtra("service1","playpuse").apply {startActivity(this)
            }
            if(togglePlaybtn){
                togglePlaybtn=false
                playbtn.setImageResource(R.drawable.baseline_stop_24)
            }
            else{
                togglePlaybtn=true
                playbtn.setImageResource(R.drawable.baseline_play_arrow_24)

            }
        }
        stopbtn.setOnClickListener{
            Intent(applicationContext,myservice::class.java).apply { stopService(this)
            if(!togglePlaybtn){
                togglePlaybtn=true
                playbtn.setImageResource(R.drawable.baseline_play_arrow_24)
            }
            }
        }
    }
}