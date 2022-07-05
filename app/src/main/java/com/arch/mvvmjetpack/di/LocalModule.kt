package com.arch.mvvmjetpack.di

import android.content.Context
import androidx.room.Room
import com.arch.mvvmjetpack.database.ChitsAppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ChitsAppDataBase {
        return Room.databaseBuilder(appContext, ChitsAppDataBase::class.java, "chits_db").build()
    }
}