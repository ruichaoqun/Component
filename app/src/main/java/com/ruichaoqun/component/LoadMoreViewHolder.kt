package com.ruichaoqun.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.ruichaoqun.component.databinding.LoadMoreViewBinding

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/1/21 17:46
 * @Description:    LoadMoreViewHolder
 * @Version:        1.0
 */
class LoadMoreViewHolder(private val binding:LoadMoreViewBinding,retry:()->Unit):RecyclerView.ViewHolder(binding.root) {
    init {
        binding.retryButton.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState:LoadState){
        if(loadState is LoadState.Error){
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible = loadState !is LoadState.Loading
        binding.errorMsg.isVisible = loadState !is LoadState.Loading
    }

    companion object{
        fun create(parent:ViewGroup,retry:()->Unit):LoadMoreViewHolder{
            val binding = LoadMoreViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return LoadMoreViewHolder(binding,retry)
        }
    }
}