package com.example.directoryoforganizations.ui.oraganization

import com.example.directoryoforganizations.data.dao.OrganizationDao
import com.example.directoryoforganizations.data.model.Organization

class OrganizationPresenter(private val dao: OrganizationDao) {
    private var setData: (models: List<Organization>) -> Unit = {}

    fun setFunctionBody(setData: (data: List<Organization>) -> Unit) {
        this.setData = setData
    }

    fun getAllOrganization(type: Int) {
        setData.invoke(dao.getAllOrganizations(type))
    }
}