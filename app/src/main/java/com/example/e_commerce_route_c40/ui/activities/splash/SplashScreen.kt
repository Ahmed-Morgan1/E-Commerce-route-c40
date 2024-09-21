package com.example.e_commerce_route_c40.ui.activities.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.example.e_commerce_route_c40.databinding.SplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreen : BaseFragment<SplashBinding,SplashViewModel>() {
    private val _viewModel:SplashViewModel by viewModels()
    override fun initViewModel(): SplashViewModel {
        return _viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.splash
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.checkLoggedInUser()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.destination.observe(viewLifecycleOwner){dest->
            if(dest == SplashDestinations.Home){
                findNavController()
                    .navigate(R.id.action_global_to_home_screen)
            }else if( dest == SplashDestinations.Login){
                findNavController()
                    .navigate(R.id.action_global_to_login_screen)
            }
        }

    }

}