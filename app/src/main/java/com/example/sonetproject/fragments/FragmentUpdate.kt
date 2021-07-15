package com.example.sonetproject.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sonetproject.R
import com.example.sonetproject.data.User
import com.example.sonetproject.databinding.FragmentAddBinding
import com.example.sonetproject.databinding.FragmentUpdateBinding
import com.example.sonetproject.repository.UserViewModel

class FragmentUpdate(val pos:Int): Fragment() {
    lateinit var binding: FragmentUpdateBinding
    lateinit var viewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        return binding.root
    }
    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.updateBtn.setOnClickListener(View.OnClickListener {

            Log.i("in---->","$pos")
            var user = User(pos+1,binding.updateFirstNameEt.text.toString(),binding.updateLastNameEt.text.toString(),binding.updateAgeEt.text.toString().toInt());

            viewModel.updateUser(user)

            val fm = activity?.supportFragmentManager
            val ft = fm?.beginTransaction()
            ft?.replace(R.id.fragment,FragmentList())
            ft?.commit()
        })
    }
}