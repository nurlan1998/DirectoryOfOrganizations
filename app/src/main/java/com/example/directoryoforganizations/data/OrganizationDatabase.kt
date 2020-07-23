package com.example.directoryoforganizations.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.directoryoforganizations.data.dao.OrganizationDao
import com.example.directoryoforganizations.data.model.Organization

@Database(entities = [Organization::class], version = 1)
abstract class OrganizationDatabase : RoomDatabase() {
    companion object {
        lateinit var INSTANCE: OrganizationDatabase

        fun getInstance(context: Context): OrganizationDatabase =
            Room.databaseBuilder(
                context,
                OrganizationDatabase::class.java,
                "directory-of-organizations.db"
            )
                .createFromAsset("directory-of-organizations.db")
                .allowMainThreadQueries()
                .build()
    }

    abstract fun dao(): OrganizationDao
}