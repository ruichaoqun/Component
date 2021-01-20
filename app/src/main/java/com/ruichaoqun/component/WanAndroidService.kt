package com.ruichaoqun.component

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/1/20 11:41
 * @Description:    WanAndroidService
 * @Version:        1.0
 */
interface WanAndroidService {
    @GET("article/list/{page}/json")
    suspend fun getHomeArticleList(@Path("page") page:Int):HomeListBean
}


@Module
@InstallIn(SingletonComponent::class)
object  NetModule{
    @Provides
    @Singleton
    fun provideWanAndroidService():WanAndroidService{
        return Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WanAndroidService::class.java)
    }
}