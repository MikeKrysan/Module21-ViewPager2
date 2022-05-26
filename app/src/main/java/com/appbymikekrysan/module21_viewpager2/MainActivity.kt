package com.appbymikekrysan.module21_viewpager2

import android.graphics.Color.green
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Создаем адаптер
        val pagerAdapter = ViewPagerAdapter()

        //Привязываем созданный адаптер к нашему ViewPager, который у нас в разметке
        viewPager2.adapter = pagerAdapter

        //Привязываем созданный адаптер к нашему ViewPager, который у нас в разметке
        viewPager2.adapter = pagerAdapter

        //Создаем список элементов, который передадим в адаптер
        val pagerItems = listOf<PagerItem> (
            PagerItem(ContextCompat.getColor(this, R.color.red), "Red"),
            PagerItem(ContextCompat.getColor(this, R.color.green), "Green"),
            PagerItem(ContextCompat.getColor(this, R.color.yellow), "Yellow")
                )

        //Передаем список в адаптер
        pagerAdapter.setItems(pagerItems)

//        viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL

        //эффект паралакс:
        viewPager2.setPageTransformer { page, position ->
             val pagerWidth = page.width

            page.textView.translationX = -position * (pagerWidth / 2)
        }


        //Мы также можем получать коллбэки о том, в каком состоянии сейчас находится ViewPager и реализовывать с помощью этого определенную логику. Применятся это с помощью метода registerOnPageChangeCallback:
        viewPager2.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                //в этом методе мы можем проверять состояние ViewPager
            }

            override fun onPageScrolled(
                position:Int,
                positionOffset:Float,
                positionOffsetPixels:Int
            ){
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                //Этот метод возвращает позицию и скролл
            }

            override fun onPageSelected(position:Int) {
                super.onPageSelected(position)
                //Этот метод возвращает текущую страницу
            }
        })
    }
}