package com.ahmetkaya.roomkullanimi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmetkaya.roomkullanimi.data.entity.Kisiler
import com.ahmetkaya.roomkullanimi.databinding.CardTasarimBinding
import com.ahmetkaya.roomkullanimi.ui.fragment.AnasayfaFragmentDirections
import com.ahmetkaya.roomkullanimi.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context, var kisiListesi: List<Kisiler>, var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimtutucu>(){

    inner class CardTasarimtutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimtutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimtutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimtutucu, position: Int) {
        val kisi = kisiListesi.get(position)
        val ht = holder.tasarim

        ht.textViewKisiAd.text = kisi.kisi_ad

        ht.cardView.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.fragmentDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        ht.imageView.setOnClickListener{
            Snackbar.make(it,"${kisi.kisi_ad} Silinsin Mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(kisi.kisi_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return kisiListesi.size
    }
}