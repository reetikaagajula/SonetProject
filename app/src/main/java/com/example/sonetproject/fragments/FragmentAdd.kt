package com.example.sonetproject.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sonetproject.R
import com.example.sonetproject.data.User
import com.example.sonetproject.databinding.FragmentAddBinding
import com.example.sonetproject.repository.UserViewModel


class FragmentAdd : Fragment() {
    lateinit var binding: FragmentAddBinding
    lateinit var viewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // var add_btn = activity?.findViewById<Button>(R.id.add_btn)
        binding.addBtn.setOnClickListener(View.OnClickListener {

            // val firstname = activity?.findViewById<EditText>(R.id.addFirstName_et)
            // val lastname = activity?.findViewById<EditText>(R.id.addLastName_et)
            // val age = activity?.findViewById<EditText>(R.id.addAge_et)

            var user = User(0,binding.addFirstNameEt.text.toString(),binding.addLastNameEt.text.toString(),binding.addAgeEt.text.toString().toInt());

            //UserData.addUser(user)

            // var userDao = UserDatabase.getDatabase(requireContext()).userDao()

            // lifecycleScope.launch {
            //     userDao.addUser(user);
            // }


            viewModel.addUser(user)

            val fm = activity?.supportFragmentManager
            val ft = fm?.beginTransaction()
            ft?.replace(R.id.fragment,FragmentList())
            ft?.commit()
        })
    }
}