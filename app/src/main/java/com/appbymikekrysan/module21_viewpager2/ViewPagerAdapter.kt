package com.appbymikekrysan.module21_viewpager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {
    //Здесб хранится списоко наших объектов с цветом и текстом
    private val items=mutableListOf<PagerItem>()

    //Этот метод мы возвращаем количество элементов в items, иногда полезно
    override fun getItemCount():Int = items.size

    //В этом методе создается ViewHolder и к нему привязывается наш item.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    //В этом методе передаются данные из items в layout
    override fun onBindViewHolder(holder:PagerViewHolder, position:Int) {
        holder.onBind(items[position])
    }

    //Этот метод наполяняет список items, нужен нам чтобы делать это извне
    fun setItems(list:List<PagerItem>) {
        items.clear()
        items.addAll(list)
    }
}