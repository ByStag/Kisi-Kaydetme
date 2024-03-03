package com.ahmetkaya.roomkullanimi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmetkaya.roomkullanimi.data.entity.Kisiler
import com.ahmetkaya.roomkullanimi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var krepo: KisilerRepository) : ViewModel() {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
    }

    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.sil(kisi_id)
            kisileriYukle()
        }
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = krepo.kisileriYukle()
        }
    }

    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = krepo.ara(aramaKelimesi)
        }
    }
}