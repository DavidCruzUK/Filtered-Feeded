package com.lastreacts.filteredfeeded.ui.activities

import android.os.Bundle
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAppComponent().inject(this)
    }

    override fun layoutRes(): Int = R.layout.activity_main
}
