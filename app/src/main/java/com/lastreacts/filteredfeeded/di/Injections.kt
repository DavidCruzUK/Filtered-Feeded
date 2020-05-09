package com.lastreacts.filteredfeeded.di

import com.lastreacts.filteredfeeded.ui.activities.MainActivity
import com.lastreacts.filteredfeeded.ui.fragments.MainFragment
import com.lastreacts.filteredfeeded.ui.fragments.TweetsListFragment

interface Injections {

    // Activities
    fun inject(activity: MainActivity)

    // Fragments
    fun inject(fragment: MainFragment)
    fun inject(fragment: TweetsListFragment)

}
