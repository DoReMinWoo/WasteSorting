package com.example.waste_sorting.Search

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class SearchAdapter(private val mCtx: Context) {
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var db: SQLiteDatabase

    private class DatabaseHelper(context: Context)
        : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL(TABLE_CREATE)
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("DROP TABLE IF EXIST " + SQLITE_TABLE)
            onCreate(p0)
        }
    }

    @kotlin.Throws(SQLiteException::class)
    fun open(): SearchAdapter {
        dbHelper = DatabaseHelper(mCtx)
        db = dbHelper.writableDatabase
        return this
    }

    fun close() {
        if(dbHelper != null) dbHelper.close()
    }

    private fun createSearch(name: String, code: String, content: String): Long {
        val value = ContentValues()
        value.put(KEY_CODE, code)
        value.put(KEY_NAME, name)
        value.put(KEY_CONTENT, content)
        return db.insert(SQLITE_TABLE, null, value)
    }

    fun insertSomeSearch() {
        createSearch("paper", "신문지",
            "종류 : 종이 \n" +
                    "- 물기에 젖지 않게 함\n" +
                    "- 비닐코팅표지, 비닐포장지, 스프링 등 이물질 제거\n" +
                    "- 내용물을 비우고 물로 한 번 헹군 후 압착\n" +
                    "- 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("paper", "책자",
            "종류 : 종이 \n" +
                    "- 물기에 젖지 않게 함\n" +
                    "- 비닐코팅표지, 비닐포장지, 스프링 등 이물질 제거\n" +
                    "- 내용물을 비우고 물로 한 번 헹군 후 압착\n" +
                    "- 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("paper", "노트",
            "종류 : 종이 \n" +
                    "- 물기에 젖지 않게 함\n" +
                    "- 비닐코팅표지, 비닐포장지, 스프링 등 이물질 제거\n" +
                    "- 내용물을 비우고 물로 한 번 헹군 후 압착\n" +
                    "- 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("paper", "종이쇼핑백",
            "종류 : 종이 \n" +
                    "- 물기에 젖지 않게 함\n" +
                    "- 비닐코팅표지, 비닐포장지, 스프링 등 이물질 제거\n" +
                    "- 내용물을 비우고 물로 한 번 헹군 후 압착\n" +
                    "- 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("paper", "상자",
            "종류 : 종이 \n" +
                    "- 물기에 젖지 않게 함\n" +
                    "- 비닐코팅표지, 비닐포장지, 스프링 등 이물질 제거\n" +
                    "- 내용물을 비우고 물로 한 번 헹군 후 압착\n" +
                    "- 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("can", "철캔",
            "종류 : 캔\n" +
                    "- 내용물을 비우고 물로 한 번 헹군 후 가능하면 압착\n" +
                    "- 겉 또는 속에 플라스틱 뚜껑이 있는 것은 플라스틱 제거\n" +
                    "- 봉투(비닐봉투도 가능)에 넣어서 배출")
        createSearch("can", "알루미늄캔",
            "종류 : 캔\n" +
                    "- 내용물을 비우고 물로 한 번 헹군 후 가능하면 압착\n" +
                    "- 겉 또는 속에 플라스틱 뚜껑이 있는 것은 플라스틱 제거\n" +
                    "- 봉투(비닐봉투도 가능)에 넣어서 배출")
        createSearch("can", "부탄가스",
            "종류 : 캔\n" +
                    "- 내용물을 비우고 물로 한 번 헹군 후 가능하면 압착\n" +
                    "- 겉 또는 속에 플라스틱 뚜껑이 있는 것은 플라스틱 제거\n" +
                    "- 봉투(비닐봉투도 가능)에 넣어서 배출")
        createSearch("glass", "음료수병",
            "종류 : 유리\n" +
                    "- 병뚜껑을 제거 후 내용물을 비우고 물로 헹구어 배출\n" +
                    "- 담배꽁초 등 이물질을 넣지 말 것 - 봉투(비닐봉투도 가능)에 넣어서 배출\n" +
                    "* 맥주, 소주병, 음료수병은 슈퍼에 팔 수 있음")
        createSearch("glass", "농약병",
            "종류 : 유리\n" +
                    "- 병뚜껑을 제거 후 내용물을 비우고 물로 헹구어 배출\n" +
                    "- 담배꽁초 등 이물질을 넣지 말 것 - 봉투(비닐봉투도 가능)에 넣어서 배출\n" +
                    "* 맥주, 소주병, 음료수병은 슈퍼에 팔 수 있음")
        createSearch("iron", "철사못 ",
            "종류 : 고철" +
                    "- 이물질이 섞이지 않도록 한 후 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("iron", "쇠붙이 ",
            "종류 : 고철" +
                    "- 이물질이 섞이지 않도록 한 후 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("iron", "양은 ",
            "종류 : 고철" +
                    "- 이물질이 섞이지 않도록 한 후 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("iron", "스테인리스 ",
            "종류 : 고철" +
                    "- 이물질이 섞이지 않도록 한 후 봉투에 넣거나 끈으로 묶어서 배출")
        createSearch("PET", "페트병",
            "종류 : 플라스틱\n" +
                    "- 뚜껑을 제거한 후 내용물을 비우고 물로 헹구어 배출\n" +
                    "- 가능한 압착하여 봉투에 넣거나 끈으로 묶어서 배출\n" +
                    "* 폐유 용기는 제외")
        createSearch("PET", "쓰레기통",
            "종류 : 플라스틱\n" +
                    "- 뚜껑을 제거한 후 내용물을 비우고 물로 헹구어 배출\n" +
                    "- 가능한 압착하여 봉투에 넣거나 끈으로 묶어서 배출\n" +
                    "* 폐유 용기는 제외")
        createSearch("PET", "세제통",
            "종류 : 플라스틱\n" +
                    "- 뚜껑을 제거한 후 내용물을 비우고 물로 헹구어 배출\n" +
                    "- 가능한 압착하여 봉투에 넣거나 끈으로 묶어서 배출\n" +
                    "* 폐유 용기는 제외")
        createSearch("PET", "합성수지용기류",
            "종류 : 플라스틱\n" +
                    "- 뚜껑을 제거한 후 내용물을 비우고 물로 헹구어 배출\n" +
                    "- 가능한 압착하여 봉투에 넣거나 끈으로 묶어서 배출\n" +
                    "* 폐유 용기는 제외")
        createSearch("Styrofoam", "재활용 스티로폼",
            "종류 : 스티로폼\n" +
                    " 이물질이 섞이지 않도록 휘날리지 않게 묶어 배출\n" +
                    "- 단, 이물질이 섞이거나 물에 젖은 스티로폼은 제외")
        createSearch("vinyl", "포장 봉지",
            "종류 : 비닐\n" +
                    "- 내용물을 깨끗이 비우고 다른 재질로 된 뚜껑, 은박지, 랩 등 부착상표 등을 깨끗이 제거 및 세척 후 묶거나 투명봉투에 넣어 배출")
        createSearch("vinyl", "과자 봉지",
            "종류 : 비닐\n" +
                    "- 내용물을 깨끗이 비우고 다른 재질로 된 뚜껑, 은박지, 랩 등 부착상표 등을 깨끗이 제거 및 세척 후 묶거나 투명봉투에 넣어 배출")
        createSearch("home appliances", "가습기",
            "종류 : 소형폐가전 제품류\n" +
                    "- 제품을 분리하지 말고 지정된 장소에 배출")
        createSearch("home appliances", "다리미",
            "종류 : 소형폐가전 제품류\n" +
                    "- 제품을 분리하지 말고 지정된 장소에 배출")
        createSearch("home appliances", "선풍기",
            "종류 : 소형폐가전 제품류\n" +
                    "- 제품을 분리하지 말고 지정된 장소에 배출")
        createSearch("home appliances", "전자렌지",
            "종류 : 소형폐가전 제품류\n" +
                    "- 제품을 분리하지 말고 지정된 장소에 배출")
        createSearch("home appliances", "컴퓨터",
            "종류 : 소형폐가전 제품류\n" +
                    "- 제품을 분리하지 말고 지정된 장소에 배출")
        createSearch("home appliances", "밥솥 ",
            "종류 : 소형폐가전 제품류\n" +
                    "- 제품을 분리하지 말고 지정된 장소에 배출")

    }

    @kotlin.Throws(SQLException::class)
    fun fetchSearchByName(inputText: String?): Cursor? {
        var mCursor: Cursor? = if (inputText == null || inputText.length == 0) {  // 필터에 입력이 안된 경우
            db.query(SQLITE_TABLE, arrayOf(KEY_ROWID, KEY_CODE, KEY_NAME, KEY_CONTENT),
                null, null, null, null, KEY_CODE)
        } else { // 필터에 값을 입력한 경우
            db!!.query(SQLITE_TABLE, arrayOf(KEY_ROWID, KEY_CODE, KEY_NAME, KEY_CONTENT),
                KEY_CODE + " LIKE '%" + inputText + "%'", null, null, null, KEY_CODE)
        }
        mCursor?.moveToFirst()
        return mCursor
    }

    fun deleteAllSearch(): Boolean {
        var result = db.delete(SQLITE_TABLE, null, null)
        return result > 0
    }

    fun fetchAllSearch(): Cursor {
        var cursor: Cursor? = null
        val query = "select * from " + SQLITE_TABLE + " order by " + KEY_NAME
        cursor = db.rawQuery(query, null)
        return cursor
    }

    companion object {
        const val KEY_ROWID = "_id"
        const val KEY_CODE = "code"
        const val KEY_NAME = "name"
        const val KEY_CONTENT = "content"
        private const val TAG = "SearchDbAdapter"
        private const val DATABASE_NAME = "Search"
        private const val SQLITE_TABLE = "WasteSorting"
        private const val DATABASE_VERSION = 1
        private const val TABLE_CREATE = "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                KEY_ROWID + " integer PRIMARY KEY autoincrement," +
                KEY_CODE + "," +
                KEY_NAME + "," +
                KEY_CONTENT + "," +
                " UNIQUE (" + KEY_CODE + "));"
    }

}