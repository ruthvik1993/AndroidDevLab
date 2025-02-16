package com.example.androiddevlab.openbrewery.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androiddevlab.AndroidDevLabApplication
import com.example.androiddevlab.ViewModelFactory
import com.example.androiddevlab.openbrewery.screen.BreweryListScreen
import com.example.androiddevlab.openbrewery.viewmodel.BreweryListViewModel
import com.example.androiddevlab.ui.theme.AndroidDevLabTheme
import javax.inject.Inject


class BreweryListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: BreweryListViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as? AndroidDevLabApplication)?.getAndroidDevLabAppComponent()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext())
            .apply {
                setContent {
                    AndroidDevLabTheme {
                        val viewState by viewModel.breweryListViewStateFlow.collectAsStateWithLifecycle()
                        BreweryListScreen(viewState = viewState)
                    }
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()
    }
}