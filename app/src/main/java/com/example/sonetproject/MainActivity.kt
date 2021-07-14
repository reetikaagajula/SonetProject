package com.example.sonetproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.sonetproject.databinding.ActivityMainBinding
import com.example.sonetproject.fragments.FragmentList

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragment,FragmentList())
        ft.commit()
    }
}