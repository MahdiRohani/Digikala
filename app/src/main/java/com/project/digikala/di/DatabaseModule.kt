package com.project.digikala.di

import android.content.Context
import androidx.room.Room
import com.project.digikala.data.db.DigikalaDatabase
import com.project.digikala.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context) =
        Room.databaseBuilder(
            context,
            DigikalaDatabase::class.java,
            DATABASE_NAME
        ).build()


}