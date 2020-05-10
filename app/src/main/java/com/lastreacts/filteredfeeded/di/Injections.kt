package com.lastreacts.filteredfeeded.di

import com.lastreacts.filteredfeeded.ui.fragments.MainFragment
import com.lastreacts.filteredfeeded.ui.fragments.TweetsListFragment

interface Injections {

    fun inject(fragment: MainFragment)
    fun inject(fragment: TweetsListFragment)

}
