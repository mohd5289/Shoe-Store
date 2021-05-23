package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters

lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
  binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

binding.btnLogin.setOnClickListener({ view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())})

        binding.btnSignUp.setOnClickListener({ view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())})

        // Inflate the layout for this fragment
        return binding.root
    }


}