package com.example.directoryoforganizations.ui.oraganization

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.directoryoforganizations.R
import com.example.directoryoforganizations.data.OrganizationDatabase
import com.example.directoryoforganizations.data.dao.OrganizationDao
import com.example.directoryoforganizations.ui.MainActivity
import kotlinx.android.synthetic.main.organization_fragment.*

class OrganizationFragment : Fragment(R.layout.organization_fragment) {
    private val adapter = OrganizationListAdapter()
    private lateinit var dao: OrganizationDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        val type = requireArguments().getInt(MainActivity.TYPE_ID)
        dao = OrganizationDatabase.getInstance(requireContext()).dao()
        setData(type)

    }
    private fun setData(type: Int){
        adapter.models = dao.getAllOrganizations(type)
    }
}