package com.ruichaoqun.component

import com.ruichaoqun.component.data.HomeListBean
import com.ruichaoqun.component.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
    suspend fun getHomeArticleList(@Path("page") page:Int): HomeListBean
}


@Module
@InstallIn(SingletonComponent::class)
object  NetModule{
    @Provides
    @Singleton
    fun provideWanAndroidService():WanAndroidService{
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
        return Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WanAndroidService::class.java)
    }

    @Provides
    fun provideHomeRepository(service:WanAndroidService): HomeRepository {
        return HomeRepository(service)
    }
}