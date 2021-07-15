package com.example.sonetproject.repository

import android.app.Application
import android.content.ClipData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sonetproject.data.User
import com.example.sonetproject.data.UserDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    var repo:UserRepository

    init{
        val userDao = UserDatabase.getDatabase(application).userDao()
        repo = UserRepository(userDao)
        readAllData = repo.readAllData
    }

    fun addUser(user:User){
        viewModelScope.launch {
            repo.addUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            repo.updateUser(user)
        }
    }

}