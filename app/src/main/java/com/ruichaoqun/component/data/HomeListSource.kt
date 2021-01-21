package com.ruichaoqun.component.data

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Error
import androidx.paging.PagingSource.LoadResult.Page
import com.ruichaoqun.component.WanAndroidService
import retrofit2.HttpException
import java.io.IOException

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/1/20 11:06
 * @Description:    HomeListSource
 * @Version:        1.0
 */
private const val START_PAGING_INDEX = 1
class HomeListSource(private val service:WanAndroidService):PagingSource<Int, HomeListBean.HomeData.HomeListData>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeListBean.HomeData.HomeListData> {
        val position = params.key?:START_PAGING_INDEX
        return try {
            val response = service.getHomeArticleList(position)
            if(response.errorCode == 0){
                val repose = response.data?.datas
                val nextKey = if(repose?.isNullOrEmpty() == true){
                    null
                }else{
                    position + 1
                }
                Page(data = repose,prevKey = if(position == START_PAGING_INDEX) null else position,nextKey = nextKey)
            }else{
                Error(Throwable(response.errorMsg))
            }
        }catch (exception:IOException){
            return Error(exception)
        }catch (exception:HttpException){
            return Error(exception)
        }
    }
}