package com.example.learn1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TransformActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transform)

        var btnTransMain : Button = findViewById(R.id.btnTransMain)
        btnTransMain.setOnClickListener {
            finish()
        }

    }
}