package com.ruichaoqun.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.ruichaoqun.component.data.HomeListBean
import com.ruichaoqun.component.databinding.ItemAdapterHomeArticleBinding
import javax.inject.Inject

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/1/20 14:39
 * @Description:    HomeArticleAdapter
 * @Version:        1.0
 */
class HomeArticleAdapter @Inject constructor(): PagingDataAdapter<HomeListBean.HomeData.HomeListData, HomeArticleAdapter.ViewHolder>(diffCallback = object :
    ItemCallback<HomeListBean.HomeData.HomeListData>(){
    override fun areItemsTheSame(
        oldItem: HomeListBean.HomeData.HomeListData,
        newItem: HomeListBean.HomeData.HomeListData
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: HomeListBean.HomeData.HomeListData,
        newItem: HomeListBean.HomeData.HomeListData
    ): Boolean {
        return oldItem == newItem
    }
}) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ItemAdapterHomeArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}