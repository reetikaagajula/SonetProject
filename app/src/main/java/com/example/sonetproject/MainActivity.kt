package com.example.sonetproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.sonetproject.fragments.FragmentList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragment,FragmentList())
        ft.commit()
    }
}