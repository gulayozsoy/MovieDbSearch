package com.example.moviedbsearch.di

import com.example.moviedbsearch.util.Constants.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    fun provideInterceptor():HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }



  fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
      val client = OkHttpClient().newBuilder()
          .connectTimeout(20, TimeUnit.SECONDS)

      if (BuildConfig.DEBUG) {
          client.addInterceptor(interceptor)
      }
      return client.build()
  }


    fun provideMoshiConverter(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )
    }

    fun provideRetrofit(factory: MoshiConverterFactory, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(factory)
            .client(client)
            .build()
    }

    single { provideInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideMoshiConverter() }
    single { provideRetrofit(get(), get()) }
}