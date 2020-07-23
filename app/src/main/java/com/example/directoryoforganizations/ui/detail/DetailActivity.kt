package com.example.directoryoforganizations.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.directoryoforganizations.R
import com.example.directoryoforganizations.data.OrganizationDatabase
import com.example.directoryoforganizations.data.dao.OrganizationDao
import com.example.directoryoforganizations.data.model.Organization
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {

    companion object {
        const val ORGANIZATION_ID = "organizationId"
    }

    private var organizationId: Int = 0
    private lateinit var dao: OrganizationDao
    private lateinit var currentOrganization: Organization
    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        dao = OrganizationDatabase.getInstance(this).dao()
        presenter = DetailPresenter(dao, this)
        organizationId = intent.getIntExtra(ORGANIZATION_ID, 0)
        presenter.getOrganizationById(organizationId)
    }

    override fun setDetailInfo(organization: Organization) {
        currentOrganization = organization
        tvName.text = organization.nameOrganizations
        tvAboutOrganization.text = organization.aboutOrganization
        tvPhoneNumber.text = organization.phoneNumber
        tvAddress.text = organization.adress
    }
}
