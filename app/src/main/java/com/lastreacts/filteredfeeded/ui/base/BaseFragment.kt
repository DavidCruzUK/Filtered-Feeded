package com.lastreacts.filteredfeeded.ui.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.lastreacts.filteredfeeded.App
import com.lastreacts.filteredfeeded.di.ApplicationComponent

abstract class BaseFragment: Fragment() {

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected fun getAppComponent(): ApplicationComponent =
        (activity?.application as App).applicationComponent

}