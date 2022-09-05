package com.route.islami_progect_c36

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class AhadethDetailsActivity : AppCompatActivity() {
    val ahadethList  = ArrayList<String>()
    lateinit var ahadethNameDetails : TextView
    lateinit var recyclerViewAhadeth : RecyclerView
    lateinit var ahadethAdapter : AhadethNameAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahadeth_details)
        ahadethNameDetails = findViewById(R.id.ahadeth_Name_Details)
        recyclerViewAhadeth = findViewById(R.id.ahadeth_verse_recycler_view)
         val ahadethName = intent.getStringExtra("hadeth_Name")
         val ahadethFile  = intent.getStringExtra("ahadeth_file")
        ahadethNameDetails.text = ahadethName
        readeAhadethFile(ahadethFile?:"")
        Log.e("Ahadeth Details" , ahadethFile?:"")
        ahadethAdapter = AhadethNameAdapter(ahadethList)
       recyclerViewAhadeth.adapter = ahadethAdapter

    }


    fun readeAhadethFile(fileName: String){
        val reader: BufferedReader

        try {
            val file = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line = reader.readLine()
            while (line != null) {
                Log.e("Sura Details" , line)
                ahadethList.add(line)
                line = reader.readLine()

            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }

    }
}