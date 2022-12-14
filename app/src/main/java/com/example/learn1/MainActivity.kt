package com.example.learn1

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.learn1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var checkApple : CheckBox
    lateinit var checkOrange : CheckBox
    lateinit var checkBanana : CheckBox

    var listner = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
        if(isChecked){
            var target = findViewById<CheckBox>(buttonView.id)
            Toast.makeText(baseContext, "${target.text} : ${isChecked}", Toast.LENGTH_SHORT).show()
        }
    }

    lateinit var binding : ActivityMainBinding
    lateinit var viewmodel : ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up an OnPreDrawListener to the root view.
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    // Check if the initial data is ready. viewModel.isReady
                    return if (true) {
                        // The content is ready; start drawing.
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        // The content is not ready; suspend.
                        false
                    }
                }
            }
        )

        var tv1 : TextView
        var tv2 : TextView
        var tv3 : TextView

        tv1 = findViewById(R.id.textView1)
        tv2 = findViewById(R.id.textView2)
        tv3 = findViewById(R.id.textView3)

        tv1.setText("???????????????")
        tv1.setTextColor(Color.RED)
        tv2.setTextSize(30.0f)
        tv2.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC)
        tv3.setText("?????????????????????????????????????????? ?????????????????????????????????????????? ?????????????????????????????????????????? ??????????????????????????????????????????")
        tv3.setSingleLine()

        checkApple = findViewById(R.id.checkBox1)
        checkOrange = findViewById(R.id.checkBox2)
        checkBanana = findViewById(R.id.checkBox3)

        checkApple.setOnCheckedChangeListener(listner)
        checkOrange.setOnCheckedChangeListener(listner)
        checkBanana.setOnCheckedChangeListener(listner)

        var btn1 : Button = findViewById(R.id.button1)
        btn1.setOnClickListener{
            startActivity(Intent(this@MainActivity, TransformActivity::class.java))
        }


    }
}