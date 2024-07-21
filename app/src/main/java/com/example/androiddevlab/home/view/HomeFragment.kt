package com.example.androiddevlab.home.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import com.example.androiddevlab.AndroidDevLabApplication
import com.example.androiddevlab.ViewModelFactory
import com.example.androiddevlab.core.extensions.collectLatestWhenStarted
import com.example.androiddevlab.home.screen.HomeScreen
import com.example.androiddevlab.home.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as? AndroidDevLabApplication)?.getAndroidDevLabAppComponent()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val viewState by viewModel.homeScreenViewStateFlow.collectAsStateWithLifecycle()
                HomeScreen(homeScreenViewState = viewState)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    private fun observe() {
        collectLatestWhenStarted(viewModel.navigateToDestinationFlow) { destination ->
            findNavController().navigate(destination)
        }
    }

}