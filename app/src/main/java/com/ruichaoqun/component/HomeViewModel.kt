package com.ruichaoqun.component

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ruichaoqun.component.data.HomeListBean
import com.ruichaoqun.component.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/1/20 14:35
 * @Description:    HomeViewModel
 * @Version:        1.0
 */
class HomeViewModel @ViewModelInject constructor(private val repository:HomeRepository):ViewModel(){


    fun getHomeArticleList(): Flow<PagingData<HomeListBean.HomeData.HomeListData>> {
        return repository.getHomeListArticleList().cachedIn(viewModelScope)
    }
}