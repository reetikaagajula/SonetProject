package com.example.sonetproject.repository

import androidx.lifecycle.LiveData
import com.example.sonetproject.data.User
import com.example.sonetproject.data.UserDAO

class UserRepository(val userDao: UserDAO) {
    val readAllData:LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user:User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }
}