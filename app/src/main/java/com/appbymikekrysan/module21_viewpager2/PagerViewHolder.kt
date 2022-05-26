package com.appbymikekrysan.module21_viewpager2

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class PagerViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    //В этом методе мы передаем данные из PagerItem в нашу верстку item.xml
    fun onBind(item:PagerItem) {
        //корневой элемент item.xml
        itemView.container.setBackgroundColor(item.color)
        //Текстовое поле
        itemView.textView.text = item.text
    }
}

/*
Класс PagerViewHolder будет для нашего ViewPager (activity_main.xml) привязывать данные из PagerItem к разметке из item.xml
 */