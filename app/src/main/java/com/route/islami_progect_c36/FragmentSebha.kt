package com.route.islami_progect_c36

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class FragmentSebha : Fragment() {
    var counter = 0
    var generalCounter = 0
    lateinit var countOfSebha: Button
    lateinit var zekr: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countOfSebha = view.findViewById(R.id.count)
        zekr = view.findViewById(R.id.count_name)

        countOfSebha.setOnClickListener {
            counter++
            generalCounter++
           if (generalCounter == 33) {
               counter = 0
                zekr.text = "الحمدلله"
            } else if (generalCounter == 66) {
                counter = 0
                zekr.text = "الله أكبر"
            } else if (generalCounter == 99) {
                counter = 0
                zekr.text = "سبحان الله"
            }
            countOfSebha.text = counter.toString()

        }
    }
}



