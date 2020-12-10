package com.appaugmentedreality.app.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.appaugmentedreality.app.R
import com.appaugmentedreality.app.data.repository.AuthRepository
import com.appaugmentedreality.app.databinding.FragmentRegBinding


class RegFragment : Fragment() {
    val parent: AuthActivity by lazy{activity as AuthActivity}
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding: FragmentRegBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.buttonLogin.setOnClickListener{
            findNavController().navigate(RegFragmentDirections.actionRegFragmentToLoginFragment())
        }
    }

    private fun observe() {
        viewModel.authReg.observe(viewLifecycleOwner){
            if(it.isConsumed){
                Log.i("Reg", "isConsumed")
            }else if (!it.isSuccess){
                Toast.makeText(parent,it.message, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(parent,it.message, Toast.LENGTH_SHORT).show()
                findNavController().navigate(RegFragmentDirections.actionRegFragmentToLoginFragment())
            }
            it.isConsumed = true
        }
    }

}