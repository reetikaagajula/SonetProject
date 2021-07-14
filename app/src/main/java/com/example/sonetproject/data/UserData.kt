package com.example.sonetproject.data

object UserData {

    var userList:List<User> = emptyList()

    fun addUser(user: User){
        userList=userList+ listOf<User>(user)
    }
}