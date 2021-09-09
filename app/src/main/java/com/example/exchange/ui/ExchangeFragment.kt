package com.example.exchange.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchange.adapters.RecyclerAdapter
import com.example.exchange.databinding.ExchangeFragmentBinding

class ExchangeFragment : Fragment() {

    private val viewModel: ExchangeViewModel by viewModels()
    private lateinit var binding: ExchangeFragmentBinding

    private lateinit var myAdapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ExchangeFragmentBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        viewModel.init()
        initRecycler()
        observe()

    }


    private fun initRecycler() {
        myAdapter = RecyclerAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.adapter = myAdapter
    }

    private fun observe() {

        viewModel._exchangeLiveData.observe(viewLifecycleOwner, {
            it[0].currencies?.toMutableList()?.let { it1 -> myAdapter.setData(it1) }
        })
    }


}