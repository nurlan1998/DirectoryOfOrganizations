package com.example.directoryoforganizations.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.directoryoforganizations.R
import com.example.directoryoforganizations.ui.oraganization.OrganizationFragment
import kotlinx.android.synthetic.main.organization_fragment.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TYPE_ID = "type_id"
        const val HOTEL = 1
        const val INSURANCE = 2
        const val BANK = 3
        const val PROSECUTORS = 4
        const val MINISTRY = 5
        const val HOSPITAL = 6
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        val fragment = OrganizationFragment()
        val bundle = Bundle()
        bundle.putInt(TYPE_ID, HOTEL)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()

        navView.setNavigationItemSelectedListener {
            var mFragment = OrganizationFragment()
            val mBundle = Bundle()
            when (it.itemId) {
                R.id.hotel -> {
                    mFragment = OrganizationFragment()
                    mBundle.putInt(TYPE_ID, HOTEL)
                    mFragment.arguments = mBundle
                }
                R.id.nav_insurance -> {
                    mFragment = OrganizationFragment()
                    mBundle.putInt(TYPE_ID, INSURANCE)
                    mFragment.arguments = mBundle
                }
                R.id.bank -> {
                    mFragment = OrganizationFragment()
                    mBundle.putInt(TYPE_ID, BANK)
                    mFragment.arguments = mBundle
                }
                R.id.nav_prosecutors -> {
                    mFragment = OrganizationFragment()
                    mBundle.putInt(TYPE_ID, PROSECUTORS)
                    mFragment.arguments = mBundle
                }
                R.id.nav_hospital -> {
                    mFragment = OrganizationFragment()
                    mBundle.putInt(TYPE_ID, HOSPITAL)
                    mFragment.arguments = mBundle
                }
                R.id.nav_ministry -> {
                    mFragment = OrganizationFragment()
                    mBundle.putInt(TYPE_ID, MINISTRY)
                    mFragment.arguments = mBundle
                }
                else -> {
                    return@setNavigationItemSelectedListener false
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment)
                .commit()
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

}
