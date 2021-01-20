package com.ruichaoqun.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ruichaoqun.component.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/1/20 14:35
 * @Description:    HomeViewModel
 * @Version:        1.0
 */
class HomeViewModel @Inject constructor(private val repository:HomeRepository):ViewModel(){


    fun getHomeArticleList(): Flow<PagingData<HomeListBean.Data.Data>> {
        return repository.getHomeListArticleList().cachedIn(viewModelScope)
    }
}