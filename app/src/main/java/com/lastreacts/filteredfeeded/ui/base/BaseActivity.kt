package com.lastreacts.filteredfeeded.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.lastreacts.filteredfeeded.App
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.di.ApplicationComponent

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected fun getAppComponent(): ApplicationComponent =
        (application as App).applicationComponent

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.app_navigation_graph).navigateUp()
}