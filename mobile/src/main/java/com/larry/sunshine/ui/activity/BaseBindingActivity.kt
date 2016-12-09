package com.larry.sunshine.ui.activity

import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem

import com.larry.sunshine.R

abstract class BaseBindingActivity<B: ViewDataBinding> : AppCompatActivity() {

    lateinit var mBinding : B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_bingding)

        mBinding = createDataBinding(savedInstanceState)

        initView()
    }

    abstract fun initView()

    /**
     * DataBinding
     */
    abstract fun createDataBinding(savedInstanceState: Bundle?): B

    fun setupToolbar(toolbar: Toolbar){
        toolbar.title = ""
        toolbar.setNavigationIcon(R.drawable.icon_return)
        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
