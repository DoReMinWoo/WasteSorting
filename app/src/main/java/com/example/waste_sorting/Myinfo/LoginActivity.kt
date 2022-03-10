package com.example.waste_sorting.Myinfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waste_sorting.Home.HomeDetailActivity
import com.example.waste_sorting.R
import kotlinx.android.synthetic.main.myinfo_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myinfo_login)

        edit_pw.setOnEditorActionListener { v, actionId, event ->
            if(actionId ==EditorInfo.IME_ACTION_DONE) {
                Login(v)
                true
            }
            else false
        }
    }
    fun Login(v : View) {
        // 키보드 숨기기
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)

        // 입력정보 비교
        if (edit_id.text.toString() == "min" && edit_pw.text.toString() == "1234" && edit_name.text.toString() =="김민우") {
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MyinfoFragment::class.java)
            startActivity(intent)
        }

        else Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
    }
}