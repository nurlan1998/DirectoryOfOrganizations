package com.example.directoryoforganizations.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.directoryoforganizations.data.model.Organization

@Dao
interface OrganizationDao {
    @Query("Select * From directory Where type = :type")
    fun getAllOrganizations(type: Int) : List<Organization>
}