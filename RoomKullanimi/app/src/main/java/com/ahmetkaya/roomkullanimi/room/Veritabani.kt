package com.ahmetkaya.roomkullanimi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmetkaya.roomkullanimi.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class Veritabani : RoomDatabase(){
    abstract fun getKisilerDao() : KisilerDao
}