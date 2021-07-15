package com.example.sonetproject.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDAO {
    @Insert
    suspend fun addUser(user:User)

    @Query("SELECT * FROM user_table")
    fun readAllData(): LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)
}