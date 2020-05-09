package com.lastreacts.filteredfeeded.di

import com.lastreacts.filteredfeeded.ui.activities.MainActivity
import com.lastreacts.filteredfeeded.ui.fragments.MainFragment

interface Injections {

    // Activities
    fun inject(mainActivity: MainActivity)

    // Fragments
    fun inject(mainFragment: MainFragment)

}
