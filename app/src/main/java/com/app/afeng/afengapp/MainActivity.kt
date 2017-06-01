package com.app.afeng.afengapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle

import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.app.afeng.afengapp.base.BaseActivity
import com.app.afeng.afengapp.ui.music.MusicDetails
import kotlinx.android.synthetic.main.content_main.*
import me.yokeyword.fragmentation.SupportFragment


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    val FIRST: Int = 0
    val SECOND: Int = 1
    val THIRD: Int = 2
    val FOURTH: Int = 3

    var mFragments = mutableListOf<SupportFragment>()  //可变列表

    /**
     * 初始化组件
     */
    override fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            mFragments.add(FIRST, MusicDetails.newInstance())
            loadMultipleRootFragment(R.id.contentContainer, FIRST, mFragments[FIRST])
        } else {
            mFragments.set(FIRST, findFragment(MusicDetails().javaClass))
        }


        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)


        bottomBar.setOnTabSelectListener({ v ->
            when (v) {
                R.id.tab_favorites -> toast("tab_favorites")
                else -> toast("else")
            }
        })
    }

    /**
     * 初始化布局
     */
    override fun getLayout(): Int {
        return R.layout.activity_main
    }


    override fun onBackPressedSupport() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressedSupport()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

                start(MusicDetails())

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
