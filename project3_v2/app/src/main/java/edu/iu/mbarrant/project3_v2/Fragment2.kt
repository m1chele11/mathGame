package edu.iu.mbarrant.project3_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {

    //variable to access frag1 saved variables
    val args: Fragment2Args by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        // find views and buttons
        val doneButton = view.findViewById<Button>(R.id.bDone)
        val answerView = view.findViewById<EditText>(R.id.editTextNumber)
        val left = view.findViewById<TextView>(R.id.tvLeft)
        val right = view.findViewById<TextView>(R.id.tvRight)
        val level = args.level
        /*
        set operation and numbers based on previous inputs
         */
        if (level=="easy"){
            var num = (0..9).random()
            var num2 = (0..9).random()
            left.text = num.toString()
            right.text = num2.toString()
        }
        if (level=="medium"){
            var num = (0..24).random()
            var num2 = (0..24).random()
            left.text = num.toString()
            right.text = num2.toString()
        }
        if (level=="hard"){
            var num = (0..49).random()
            var num2 = (0..49).random()
            left.text = num.toString()
            right.text = num2.toString()
        }
        else{var num = (0..9).random()
            var num2 = (0..9).random()
            left.text = num.toString()
            right.text = num2.toString()}

        /*
        retrieve specified operation preference and set in the textView
         */
        var opView = view.findViewById<TextView>(R.id.tvOper)
        var op = args.oper
        opView.text = op
        if (op.isEmpty()) {
            opView.text = "+"
            op = "+"
        }
        /*
        retrieve the number of questions the user wanted
         */
        var noq = args.noq
        var count = 0
        var grade = 0
        /*
        reads numbers/operation and finds the correct/expected answer
        if the answer matches the user input, total grade is increased
        does not increase if wrong/doesn't match
         */
        doneButton.setOnClickListener {
            count++
            var ans = answerView.text.toString().toInt()
            var correct = 0
            var lAns = left.text.toString().toInt()
            var rAns = right.text.toString().toInt()
            if (op.equals("+"))
                correct = lAns+rAns
            if (op.equals("-"))
                correct = lAns-rAns
            if (op.equals("/"))
                correct = lAns/rAns
            if (op.equals("X"))
                correct = lAns*rAns
            if (ans.equals(correct))
                grade++

            //when reached the selected number of questions,
            //navigate to next screen/fragment
            if (count == noq) {
                val action = Fragment2Directions.actionFragment2ToFragment3(grade, noq)
                view.findNavController().navigate(action)
            }
            /*
            if there is more questions left, reset numbers to new numbers
             */
            if (level=="easy"){
                var num = (0..9).random()
                var num2 = (0..9).random()
                left.text = num.toString()
                right.text = num2.toString()
            }
            if (level=="medium"){
                var num = (0..24).random()
                var num2 = (0..24).random()
                left.text = num.toString()
                right.text = num2.toString()
            }
            if (level=="hard"){
                var num = (0..49).random()
                var num2 = (0..49).random()
                left.text = num.toString()
                right.text = num2.toString()
            }
        }
        return view
    }
}