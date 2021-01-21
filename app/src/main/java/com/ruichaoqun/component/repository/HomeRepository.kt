package com.ruichaoqun.component.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ruichaoqun.component.data.HomeListBean
import com.ruichaoqun.component.WanAndroidService
import com.ruichaoqun.component.data.HomeListSource
import kotlinx.coroutines.flow.Flow

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/1/20 14:32
 * @Description:    HomeRepository
 * @Version:        1.0
 */
class HomeRepository(private val service:WanAndroidService) {
    fun getHomeListArticleList():Flow<PagingData<HomeListBean.HomeData.HomeListData>>{
        return Pager(config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),pagingSourceFactory = {HomeListSource(service)}
        ).flow
    }
}