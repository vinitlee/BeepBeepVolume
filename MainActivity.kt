package com.vinitlee.bose.beepbeepvolume

import android.content.Context
import android.media.AudioManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.util.Log
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mAudioManager : AudioManager
    val mStreamType = AudioManager.STREAM_MUSIC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lateinit
        mAudioManager = applicationContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val buttons = intArrayOf(R.id.button1, R.id.button2, R.id.button3, R.id.button4)
        for (b in buttons) findViewById<Button>(b).setOnClickListener(this)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.i("Down", keyCode.toString())
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        Log.i("LongPress", keyCode.toString())
        return super.onKeyLongPress(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.i("Up", keyCode.toString())
        return super.onKeyUp(keyCode, event)
    }

    override fun onClick(p0: View?) {
        Log.i("Main Onclick", p0?.id.toString())
        when (p0?.id) {
            R.id.button1 -> setVol(0)
            R.id.button2 -> setVol(30)
            R.id.button3 -> setVol(50)
            R.id.button4 -> setVol(80)
        }
    }

    fun setVol(v : Int) {
        Log.i("Main", "Setting volume to "+v)
        val max = mAudioManager.getStreamMaxVolume(mStreamType)
        mAudioManager.setStreamVolume(mStreamType, (v * max)/100, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE)
    }
}
