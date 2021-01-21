package com.ruichaoqun.component

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/1/21 18:17
 * @Description:    LoadMoreAdapter
 * @Version:        1.0
 */
class LoadMoreAdapter(private val retry:()->Unit):LoadStateAdapter<LoadMoreViewHolder>() {
    override fun onBindViewHolder(holder: LoadMoreViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadMoreViewHolder {
        return LoadMoreViewHolder.create(parent,retry)
    }
}