package com.ruichaoqun.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.ruichaoqun.component.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel by viewModels<HomeViewModel>()
    val adapter:HomeArticleAdapter = HomeArticleAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoadMoreAdapter{adapter.retry()},
            footer = LoadMoreAdapter{adapter.retry()}
        )
        initView()
        initData()
    }

    private fun initView() {
        lifecycleScope.launch {
            adapter.loadStateFlow
                .distinctUntilChangedBy { it.refresh }
                .filter { it.refresh is LoadState.NotLoading }
                .collect{binding.recyclerView.scrollToPosition(0)}
        }
    }

    private fun initData() {
        lifecycleScope.launch {
            viewModel.getHomeArticleList()
                .collect {
                    adapter.submitData(it)
                }
        }
    }
}