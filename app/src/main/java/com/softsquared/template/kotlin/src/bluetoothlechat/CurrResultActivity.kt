package com.softsquared.template.kotlin.src.bluetoothlechat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivityCurrResultBinding
import com.softsquared.template.kotlin.src.main.MainActivity

class CurrResultActivity : AppCompatActivity(){
    val binding by lazy { ActivityCurrResultBinding.inflate(layoutInflater) }
    var date:  String? = null // 양치한 날짜
    var time:  String? = null // 양치한 시간
    var brushing_time: Long ?= 0 // 양치 소요 시간
    var score: Double ?= 0.0 // 양치 점수
    var min = 0
    var sec = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curr_result)
        setTitle("양치 결과")
        time = intent.getStringExtra("time") // 초
        score = intent.getDoubleExtra("score",0.0)
        brushing_time = intent.getLongExtra("brushing_time", 0)
        score = intent.getDoubleExtra("score",0.0)
        Toast.makeText(this,"양치 시간: "+time, Toast.LENGTH_LONG).show()
        sec = brushing_time!!.toInt()
        min = sec / 60
        sec %= 60
        val timeTxt = findViewById(R.id.time_txt) as TextView
        timeTxt.setText("양치시간: $min" + "분 $sec" + "초")
        val scoreTxt = findViewById(R.id.score_txt) as TextView
        scoreTxt.setText("점수: $score" + "점")
        val okBtn = findViewById(R.id.btn_ok) as Button
        okBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}