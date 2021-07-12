package com.example.sonetproject.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.sonetproject.R

class FragmentAdd : Fragment(R.layout.activity_fragment_add) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var add_btn = activity?.findViewById<Button>(R.id.add_btn)
        add_btn?.setOnClickListener(View.OnClickListener {
            val fm = activity?.supportFragmentManager
            val ft = fm?.beginTransaction()
            ft?.replace(R.id.fragment,FragmentList())
            ft?.commit()
        })
    }
}