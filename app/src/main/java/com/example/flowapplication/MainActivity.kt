package com.example.flowapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.host_fragment)

        if (currentFragment == null) {
            val fragment = GeneralFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.host_fragment, fragment)
                .commit()
        }
    }
}