package com.ahmetkaya.roomkullanimi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ahmetkaya.roomkullanimi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor(var krepo: KisilerRepository) : ViewModel() {

    fun guncelle(kisi_id: Int, kisi_ad: String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.guncelle(kisi_id,kisi_ad)
        }
    }
}