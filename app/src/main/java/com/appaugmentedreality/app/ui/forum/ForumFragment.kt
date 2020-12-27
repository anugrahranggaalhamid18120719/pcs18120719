package com.appaugmentedreality.app.ui.forum

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.appaugmentedreality.app.R
import com.appaugmentedreality.app.databinding.FragmentForumBinding
import com.appaugmentedreality.app.ui.home.MainActivity

class ForumFragment : Fragment() {
private val perent :  MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentForumBinding

    private val viewModel: ForumViewModel by lazy { ForumViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForumBinding.inflate(inflater,container, false).apply {
            viewModel = this@ForumFragment.viewModel
            lifecycleOwner = this@ForumFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       init()
        observe()
        // TODO: Use the ViewModel
    }


    private fun init() {
        binding.recyclerView.adapter = ForumAdapter(perent)
        viewModel.listForum()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listForum()
        }


    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
        binding.swipeRefresh.isRefreshing = it
        }

        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("ActionState", "isConsumed")
            }else if (!it.isConsumed){
                Toast.makeText(perent, it.message, Toast.LENGTH_SHORT).show()
            }

        }
    }

}