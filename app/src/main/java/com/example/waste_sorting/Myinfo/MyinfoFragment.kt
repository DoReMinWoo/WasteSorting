package com.example.waste_sorting.Myinfo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.waste_sorting.R
import kotlinx.android.synthetic.main.activity_homedetail.*
import kotlinx.android.synthetic.main.fragment_myinfo.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyinfoFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_myinfo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myinfo_login_btn.setOnClickListener {
            activity?.let {
                val intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        myinfo_register_btn.setOnClickListener {
            activity?.let {
                val intent = Intent(context, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}