package com.example.notes_app_viewmodel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class noteDB:RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object{
        @Volatile
        private var INSTANCE:noteDB? = null

        fun getDatabase(context: Context): noteDB{
            val tempInstance = INSTANCE

            if(tempInstance!= null){
                return tempInstance
            }
            //so it font create 2 instances of database By accident
            synchronized(this){
                //create instance if we don't have it already
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    noteDB::class.java,
                    "notes"
                ).fallbackToDestructiveMigration() //delete previous versions if incremented
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}