package com.meetsuccess.roomdatabasekotling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database= ContactDatabase.getContactDatabase(this@MainActivity)

        GlobalScope.launch {
            database .contactDao().insertContact(contact(0,"ddd","3232", Date(),1))
        }


    }
    public fun getData(view: View)
    {
        database.contactDao().getContact().observe(this,{
    Log.d("dddd",it.toString())
}

)
    }
}