package com.example.waste_sorting.Search

import android.database.Cursor
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.waste_sorting.R

class SearchActivity: AppCompatActivity() {
    private var dbHelper: SearchAdapter? = null
    private var dataAdapter: SimpleCursorAdapter? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        dbHelper = SearchAdapter(this)
        dbHelper!!.open()

        //Clean all data
        dbHelper!!.deleteAllSearch()
        //Add some data
        dbHelper!!.insertSomeSearch()

        //Generate ListView from SQLite Database
        displayListView()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper!!.close()
    }

    private fun displayListView() {
        val cursor = dbHelper!!.fetchAllSearch()

        // The desired columns to be bound
        val columns = arrayOf(
            SearchAdapter.KEY_CODE,
            SearchAdapter.KEY_NAME,
            SearchAdapter.KEY_CONTENT)

        // the XML defined views which the data will be bound to
        val to = intArrayOf(
            R.id.code,
            R.id.name,
            R.id.content)

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = SimpleCursorAdapter(
            this, R.layout.search_info,
            cursor,
            columns,
            to,
            0)
        val listView = findViewById<View>(R.id.listView1) as ListView
        // Assign adapter to ListView
        listView.adapter = dataAdapter
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { listView, view, position, id -> // Get the cursor, positioned to the corresponding row in the result set
                val cursor = listView.getItemAtPosition(position) as Cursor

                // Get the state's capital from this row in the database.
                val searchCode = cursor.getString(cursor.getColumnIndexOrThrow("code"))
                Toast.makeText(
                    applicationContext,
                    searchCode, Toast.LENGTH_SHORT
                ).show()
            }
        dataAdapter!!.filterQueryProvider = FilterQueryProvider { constraint -> dbHelper!!.fetchSearchByName(constraint.toString())!! }
        val myFilter = findViewById<View>(R.id.myFilter) as EditText
        myFilter.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                dataAdapter!!.filter.filter(s.toString())
            }
        })
    }
}