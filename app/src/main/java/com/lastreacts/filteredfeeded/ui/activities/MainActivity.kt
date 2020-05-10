package com.lastreacts.filteredfeeded.ui.activities

import android.os.Bundle
import androidx.navigation.Navigation
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAppComponent().inject(this)
    }

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.app_navigation_graph).navigateUp()
}
