package com.example.directoryoforganizations.ui.oraganization

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.directoryoforganizations.R
import com.example.directoryoforganizations.data.model.Organization
import kotlinx.android.synthetic.main.organization_item.view.*

class OrganizationListAdapter : RecyclerView.Adapter<OrganizationListAdapter.OrganizationListViewHolder>() {

    var models:List<Organization> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationListViewHolder {
        var view =LayoutInflater.from(parent.context).inflate(R.layout.organization_item,parent,false)
        return OrganizationListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: OrganizationListViewHolder, position: Int) {
        holder.populate(models[position])
    }

    inner class OrganizationListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun populate(organization: Organization){
            itemView.tvName.text = organization.nameOrganizations
            itemView.tvAbout.text = organization.aboutOrganization
        }
    }
}