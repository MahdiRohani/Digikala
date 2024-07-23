package com.project.digikala.di

import android.content.Context
import com.project.digikala.data.datastore.DataStoreRepository
import com.project.digikala.data.datastore.DataStoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {
    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) : DataStoreRepository = DataStoreRepositoryImpl(context)
}