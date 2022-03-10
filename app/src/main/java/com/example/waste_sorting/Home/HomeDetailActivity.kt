package com.example.waste_sorting.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waste_sorting.R
import kotlinx.android.synthetic.main.activity_homedetail.*

class HomeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homedetail)

        detail_img.setImageResource(intent.getIntExtra("detail_img", 0))
        detail_title.setText(intent.getStringExtra("title"))
        detail_text1.setText(intent.getStringExtra("detail_text1"))
        detail_center_img.setImageResource(intent.getIntExtra("detail_center_img", 0))
        detail_text2.setText(intent.getStringExtra("detail_text2"))

    }
}