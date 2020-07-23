package com.example.directoryoforganizations.ui.detail

import com.example.directoryoforganizations.data.dao.OrganizationDao

class DetailPresenter(private val dao: OrganizationDao, private val view: DetailView) {
    fun getOrganizationById(id: Int){
        view.setDetailInfo(dao.getOrganizationById(id))
    }
}