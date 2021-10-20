package com.meetsuccess.roomdatabasekotling

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [contact::class],version = 2)
@TypeConverters(converter::class)
abstract class  ContactDatabase:RoomDatabase() {
    abstract fun contactDao():Dao
    companion object{

        val migration_1_2=object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }
        @Volatile  //it will tel to all database instance,its updated value is new one
        private var database: ContactDatabase?=null
        fun getContactDatabase(context: Context):ContactDatabase{
            if(database==null)
            {
                synchronized(this){
                    database= Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,"contactDb").
                        addMigrations(migration_1_2).build()
                }



            }

                return database!!
        }

    }

}