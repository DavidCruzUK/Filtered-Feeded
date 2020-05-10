package com.lastreacts.filteredfeeded.ui.activities

import androidx.navigation.Navigation
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.app_navigation_graph).navigateUp()
}
