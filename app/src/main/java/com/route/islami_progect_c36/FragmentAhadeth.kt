package com.route.islami_progect_c36

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class FragmentAhadeth : Fragment() {

    lateinit var recyclerViewAhadeth : RecyclerView
    lateinit var adapterAhadeth : AhadethNameAdapter
     var listAhadeth : List<String> = listOf("الحديث رقم 1","الحديث رقم 2","الحديث رقم 3","الحديث رقم 4","الحديث رقم 5",
         "الحديث رقم 6","الحديث رقم 7","الحديث رقم 8","الحديث رقم 9","الحديث رقم 10","الحديث رقم 11","الحديث رقم 12",
         "الحديث رقم 13","الحديث رقم 14","الحديث رقم 15","الحديث رقم 16","الحديث رقم 17","الحديث رقم 18","الحديث رقم 19","الحديث رقم 20",
         "الحديث رقم 21","الحديث رقم 22","الحديث رقم 23","الحديث رقم 24","الحديث رقم 25","الحديث رقم 26","الحديث رقم 27",
         "الحديث رقم 28","الحديث رقم 29","الحديث رقم 30","الحديث رقم 31","الحديث رقم 32","الحديث رقم 33","الحديث رقم 34",
         "الحديث رقم 35","الحديث رقم 36","الحديث رقم 37","الحديث رقم 38","الحديث رقم 39","الحديث رقم 40","الحديث رقم 41",
         "الحديث رقم 42","الحديث رقم 43","الحديث رقم 44","الحديث رقم 45","الحديث رقم 46","الحديث رقم 47","الحديث رقم 48",
         "الحديث رقم 49","الحديث رقم 50",)



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewAhadeth = view.findViewById(R.id.sura_Names_Recycler_View_ahadeth)
        adapterAhadeth = AhadethNameAdapter(listAhadeth)
        adapterAhadeth.onAhadethClicked = object : AhadethNameAdapter.OnItemClickListenerAhadeth{
            override fun onItemClickListenerAhadeth(hadethName : String,index: Int) {
                startAhadethDetailsActivity(hadethName,"h${index+1}.txt")
            }
        }


        recyclerViewAhadeth.adapter = adapterAhadeth


    }

    private fun startAhadethDetailsActivity(hadethName: String ,fileName: String) {
        val intent = Intent(activity , AhadethDetailsActivity::class.java)
        intent.putExtra("hadeth_Name", hadethName)
        intent.putExtra("ahadeth_file" , fileName)
        activity?.startActivity(intent)
    }

}
