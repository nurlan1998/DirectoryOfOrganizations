package com.example.directoryoforganizations.ui.oraganization

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.directoryoforganizations.R
import com.example.directoryoforganizations.data.OrganizationDatabase
import com.example.directoryoforganizations.data.dao.OrganizationDao
import com.example.directoryoforganizations.ui.MainActivity
import com.example.directoryoforganizations.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.organization_fragment.*

class OrganizationFragment : Fragment(R.layout.organization_fragment) {
    private val adapter = OrganizationListAdapter()
    private lateinit var dao: OrganizationDao
    private lateinit var presenter: OrganizationPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setOnItemClickListener {
            var mIntent = Intent(requireActivity(), DetailActivity::class.java)
            mIntent.putExtra(DetailActivity.ORGANIZATION_ID,it)
            startActivity(mIntent)
        }
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL))
        val type = requireArguments().getInt(MainActivity.TYPE_ID)
        dao = OrganizationDatabase.getInstance(requireContext()).dao()
        presenter = OrganizationPresenter(dao)
        presenter.setFunctionBody {
            adapter.models = it
        }
        presenter.getAllOrganization(type)
    }
}