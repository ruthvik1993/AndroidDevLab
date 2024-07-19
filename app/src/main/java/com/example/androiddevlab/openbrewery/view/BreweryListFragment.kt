package com.example.androiddevlab.openbrewery.view

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androiddevlab.AndroidDevLabApplication
import com.example.androiddevlab.ViewModelFactory
import com.example.androiddevlab.openbrewery.viewmodel.BreweryListViewModel
import javax.inject.Inject


class BreweryListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: BreweryListViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as? AndroidDevLabApplication)?.getAndroidDevLabAppComponent()?.inject(this)
    }
}