package com.route.islami_progect_c36

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {
     var listFile = ArrayList<String>()
     lateinit var suraNameTextView : TextView
     lateinit var recyclerView: RecyclerView
     lateinit var suraNAmesAdapter: SuraNamesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_name)
        recyclerView = findViewById(R.id.sura_verse_recycler_view)
        suraNameTextView = findViewById(R.id.suraName_Details)
        val suraName = intent.getStringExtra("suraName")
        val fileName = intent.getStringExtra("fileName")
        suraNameTextView.text=suraName
        readeSuraFile(fileName?:"")
        suraNAmesAdapter = SuraNamesAdapter(listFile)
        recyclerView.adapter = suraNAmesAdapter

    }
    fun readeSuraFile(fileName: String){
        val reader: BufferedReader

        try {
            val file = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line = reader.readLine()
            while (line != null) {
                listFile.add(line)
                line = reader.readLine()

            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }

    }
}