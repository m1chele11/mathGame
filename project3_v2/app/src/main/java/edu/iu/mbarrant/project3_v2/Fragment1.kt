package edu.iu.mbarrant.project3_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        /*
        set number of questions view and buttons
         */
        val numQ = view.findViewById<TextView>(R.id.tvNofQ)
        val more = view.findViewById<Button>(R.id.bMore)
        more.setOnClickListener {
            numQ.text = (numQ.text.toString().toInt() + 1).toString()
        }
        val less = view.findViewById<Button>(R.id.bLess)
        less.setOnClickListener {
            if (numQ.text.toString().toInt() > 0)
                numQ.text = (numQ.text.toString().toInt() - 1).toString()
        }
        /*
        find buttons for access on first page/fragment
         */
        val startButton = view.findViewById<Button>(R.id.bStart)
        val easy = view.findViewById<RadioButton>(R.id.rbEasy)
        val med = view.findViewById<RadioButton>(R.id.rbMedium)
        val hard = view.findViewById<RadioButton>(R.id.rbHard)
        val add = view.findViewById<RadioButton>(R.id.rbAdd)
        val sub = view.findViewById<RadioButton>(R.id.rbSub)
        val mul = view.findViewById<RadioButton>(R.id.rbMul)
        val div = view.findViewById<RadioButton>(R.id.rbDiv)
        var count = 0
        var count2 = 0

        /*
        when a radio button is clicked, prevents other buttons from also being pressed
        when its double clicked, it un selects and makes all other buttons clickable again
         */
        easy.setOnClickListener {
            med.isClickable = false
            hard.isClickable = false
            if (easy.isChecked && count == 1) {
                easy.isChecked = false
                med.isClickable = true
                hard.isClickable = true
                count = 0
            } else count = 1
        }
        med.setOnClickListener {
            easy.isClickable = false
            hard.isClickable = false
            if (med.isChecked && count == 1) {
                med.isChecked = false
                easy.isClickable = true
                hard.isClickable = true
                count = 0
            } else count = 1
        }
        hard.setOnClickListener {
            med.isClickable = false
            easy.isClickable = false
            if (hard.isChecked && count == 1) {
                hard.isChecked = false
                med.isClickable = true
                easy.isClickable = true
                count = 0
            } else count = 1
        }
        add.setOnClickListener {
            sub.isClickable = false
            mul.isClickable = false
            div.isClickable = false
            if (add.isChecked && count2 == 1) {
                add.isChecked = false
                sub.isClickable = true
                mul.isClickable = true
                div.isClickable = true
                count2 = 0
            } else count2 = 1
        }
        sub.setOnClickListener {
            add.isClickable = false
            mul.isClickable = false
            div.isClickable = false
            if (sub.isChecked && count2 == 1) {
                sub.isChecked = false
                add.isClickable = true
                mul.isClickable = true
                div.isClickable = true
                count2 = 0
            } else count2 = 1
        }
        mul.setOnClickListener {
            sub.isClickable = false
            add.isClickable = false
            div.isClickable = false
            if (mul.isChecked && count2 == 1) {
                mul.isChecked = false
                sub.isClickable = true
                add.isClickable = true
                div.isClickable = true
                count2 = 0
            } else count2 = 1
        }
        div.setOnClickListener {
            sub.isClickable = false
            mul.isClickable = false
            add.isClickable = false
            if (div.isChecked && count2 == 1) {
                div.isChecked = false
                sub.isClickable = true
                mul.isClickable = true
                add.isClickable = true
                count2 = 0
            } else count2 = 1
        }

        /*
        functionality for start button
         */
        startButton.setOnClickListener {
            var oper = ""
            var level = ""
            //find selected operation
            if (add.isChecked)
                oper = "+"
            if (sub.isChecked)
                oper = "-"
            if (mul.isChecked)
                oper = "X"
            if (div.isChecked)
                oper = "/"
            //find selected number of questions
            var noq = numQ.text.toString().toInt()
            if (easy.isChecked)
                level = "easy"
            if (med.isChecked)
                level = "medium"
            if (hard.isChecked)
                level = "hard"

            //save variables and navigate to next page
            val action = Fragment1Directions.actionFragment1ToFragment2(oper, noq, level)
            view.findNavController().navigate(action)

        }
        // }

        return view
    }

}