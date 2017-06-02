package com.app.afeng.afengapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle

import android.support.v7.widget.Toolbar
import com.app.afeng.afengapp.base.BaseActivity
import com.app.afeng.afengapp.ui.music.MusicDetails
import com.app.afeng.afengapp.ui.music.MusicFragment
import com.app.afeng.afengapp.ui.mv.MvFragment
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.activity_main.*

import me.yokeyword.fragmentation.SupportFragment
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.os.Build
import android.animation.Animator
import android.view.*
import com.app.afeng.afengapp.tools.Utils


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    val Music: Int = R.id.tab_music
    val MV: Int = R.id.tab_mv
    val MU: Int = 2
    val FOURTH: Int = 3

    val MUDetalis: Int = 9


    var mFragmentsDict = mutableMapOf<Int, SupportFragment>()

    /**
     * 初始化组件
     */
    override fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {

            mFragmentsDict[Music] = MusicFragment.newInstance()
            mFragmentsDict[MV] = MvFragment.newInstance()


            mFragmentsDict[MUDetalis] = MusicDetails.newInstance()


            //装载fragment，所有的都要放进来
            loadMultipleRootFragment(R.id.contentContainer, 0, mFragmentsDict[Music], mFragmentsDict[MV])

        } else {
            mFragmentsDict[Music] = findFragment(MusicFragment().javaClass)
            mFragmentsDict[MV] = findFragment(MvFragment().javaClass)

            mFragmentsDict[MUDetalis] = findFragment(MusicDetails().javaClass)

        }


        setupview()


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

            showHideFragment(mFragmentsDict[v], mFragmentsDict[bottomBar.currentTabId])


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


    fun setupview() {
        // 1. 状态栏侵入
        var adjustStatusHeight = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            adjustStatusHeight = true
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            } else {
                window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            }
        }

        // 2. 状态栏占位View的高度调整
        val brand = Build.BRAND
        if (brand.contains("Xiaomi")) {
            Utils.setXiaomiDarkMode(this)
        } else if (brand.contains("Meizu")) {
            Utils.setMeizuDarkMode(this)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decor = window.decorView
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            adjustStatusHeight = false
        }
        if (adjustStatusHeight) {
            adjustStatusBarHeight() // 调整状态栏高度
        }
    }

    /**
     * 调整沉浸状态栏
     */
    fun adjustStatusBarHeight() {
        val statusBarHeight: Int = Utils.getStatusBarHeight(this)
        val lp: ViewGroup.LayoutParams = positionView.layoutParams
        lp.height = statusBarHeight
        positionView.layoutParams = lp
    }


}
