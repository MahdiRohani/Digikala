package com.project.digikala.di

import android.content.Context
import com.project.digikala.data.datastore.DataStoreRepository
import com.project.digikala.data.datastore.DataStoreRepositoryImpl
import com.project.digikala.data.remote.CategoryApiInterface
import com.project.digikala.data.remote.HomeApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CategoryApiInterfaceModule {
    @Provides
    @Singleton
    fun provideCategoryApiInterface(retrofit: Retrofit) : CategoryApiInterface =
        retrofit.create(CategoryApiInterface::class.java)
}