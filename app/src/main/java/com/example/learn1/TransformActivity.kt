package com.example.learn1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learn1.common.ViewPagerAdapter
import com.example.learn1.databinding.ActivityMainBinding
import com.example.learn1.databinding.ActivityTransformBinding
import com.google.android.material.tabs.TabLayoutMediator

class TransformActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTransformBinding

    private val tabTitleArray = arrayOf("First Tab", "Second Tab", "Third Tab")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransformBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_transform)

        binding.apply {
            viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
            TabLayoutMediator(tabLayout, viewPager){
                    tab, position -> tab.text = tabTitleArray[position]
            }.attach()
        }

    }
}