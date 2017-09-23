package info.metadude.kotlin.library.c3media

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RxApiModule {

    fun provideRxC3MediaService(baseUrl: String,
                                okHttpClient: OkHttpClient
    ): RxC3MediaService = createRetrofit(baseUrl = baseUrl, okHttpClient = okHttpClient)
            .create(RxC3MediaService::class.java)

    private fun createRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(ApiModule.provideMoshiBuilder()))
                .client(okHttpClient)
                .build()
    }
}