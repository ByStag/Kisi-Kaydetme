package com.ahmetkaya.roomkullanimi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ahmetkaya.roomkullanimi.R
import com.ahmetkaya.roomkullanimi.databinding.FragmentKayitBinding
import com.ahmetkaya.roomkullanimi.ui.viewmodel.KayitViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.buttonKaydet.setOnClickListener {
            Snackbar.make(it,"Kayıt Edilsin Mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    val kisi_ad = binding.editTextKisiAd.text.toString()
                    kaydet(kisi_ad)
                }.show()
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun kaydet(kisi_ad: String){
        viewModel.kaydet(kisi_ad)
    }
}