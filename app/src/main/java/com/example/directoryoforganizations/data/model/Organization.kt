package com.example.directoryoforganizations.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "directory")
data class Organization(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "nameOrganizations")
    val nameOrganizations: String,

    @ColumnInfo(name = "aboutOrganization")
    val aboutOrganization: String,

    @ColumnInfo(name = "adress")
    val adress: String,

    @ColumnInfo(name = "phoneNumber")
    val phoneNumber: String
)