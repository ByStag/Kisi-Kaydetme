package com.ahmetkaya.roomkullanimi.di

import android.content.Context
import androidx.room.Room
import com.ahmetkaya.roomkullanimi.data.datasource.KisilerDataSource
import com.ahmetkaya.roomkullanimi.data.repo.KisilerRepository
import com.ahmetkaya.roomkullanimi.room.KisilerDao
import com.ahmetkaya.roomkullanimi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerDataSource(kdao: KisilerDao) : KisilerDataSource{
        return KisilerDataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds : KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : KisilerDao{
        val vt = Room.databaseBuilder(context, Veritabani::class.java, name = "kisiler.sqlite")
            .createFromAsset("kisiler.sqlite").build()
        return vt.getKisilerDao()
    }
}