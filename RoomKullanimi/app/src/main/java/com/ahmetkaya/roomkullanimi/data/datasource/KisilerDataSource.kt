package com.ahmetkaya.roomkullanimi.data.datasource

import android.util.Log
import com.ahmetkaya.roomkullanimi.data.entity.Kisiler
import com.ahmetkaya.roomkullanimi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao: KisilerDao) {

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext kdao.kisileriYukle()
        }

    suspend fun ara(aramaKelimesi: String): List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext kdao.ara(aramaKelimesi)
        }

    suspend fun kaydet(kisi_ad: String){
        val yeniKisi = Kisiler(0,kisi_ad)
        kdao.kaydet(yeniKisi)
    }

    suspend fun guncelle(kisi_id: Int, kisi_ad: String){
        val guncelleKisi = Kisiler(kisi_id, kisi_ad)
        kdao.guncelle(guncelleKisi )
    }

    suspend fun sil(kisi_id:Int){
        val silKisi = Kisiler(kisi_id,"")
        kdao.sil(silKisi)
    }
}