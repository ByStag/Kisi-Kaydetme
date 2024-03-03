package com.ahmetkaya.roomkullanimi.data.repo

import com.ahmetkaya.roomkullanimi.data.datasource.KisilerDataSource
import com.ahmetkaya.roomkullanimi.data.entity.Kisiler
import javax.inject.Inject

class KisilerRepository @Inject constructor(var kds: KisilerDataSource) {

    suspend fun kaydet(kisi_ad: String) = kds.kaydet(kisi_ad)

    suspend fun guncelle(kisi_id: Int, kisi_ad: String) = kds.guncelle(kisi_id,kisi_ad)

    suspend fun sil(kisi_id:Int) = kds.sil(kisi_id)

    suspend fun kisileriYukle() : List<Kisiler> = kds.kisileriYukle()

    suspend fun ara(aramaKelimesi: String): List<Kisiler> = kds.ara(aramaKelimesi)
}