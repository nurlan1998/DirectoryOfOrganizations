package com.example.directoryoforganizations.ui.detail

import com.example.directoryoforganizations.data.model.Organization

interface DetailView {
    fun setDetailInfo(organization: Organization)
}