package com.ahmetkaya.roomkullanimi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetkaya.roomkullanimi.R
import com.ahmetkaya.roomkullanimi.databinding.FragmentDetayBinding
import com.ahmetkaya.roomkullanimi.ui.viewmodel.DetayViewModel
import com.ahmetkaya.roomkullanimi.ui.viewmodel.KayitViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)
        val view = binding.root

        val bundle: DetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.editTextKisiAd.setText(gelenKisi.kisi_ad)


        binding.buttonGuncelle.setOnClickListener {
            Snackbar.make(it,"Güncellensin Mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    val kisi_ad = binding.editTextKisiAd.text.toString()
                    guncelle(gelenKisi.kisi_id,kisi_ad)
                }.show()
        }

        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun guncelle(kisi_id: Int, kisi_ad: String){
        viewModel.guncelle(kisi_id,kisi_ad)
    }
}