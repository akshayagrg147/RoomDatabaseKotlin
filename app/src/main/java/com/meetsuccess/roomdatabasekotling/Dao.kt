package com.meetsuccess.roomdatabasekotling

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    @Insert
   suspend fun insertContact(contact: contact)
    @Delete
   suspend fun deleteContact(contact: contact)
    @Update
   suspend fun updateContact(contact: contact)
    @Query("SELECT * FROM contact")
    fun getContact():LiveData<List<contact>>
}