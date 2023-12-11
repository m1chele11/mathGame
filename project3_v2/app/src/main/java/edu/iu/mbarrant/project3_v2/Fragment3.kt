package edu.iu.mbarrant.project3_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment3 : Fragment() {

    //collect previous variables
    val args: Fragment3Args by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_3, container, false)

        /*
        update grade to show how many questions user got correct,
        out of the number of questions they had/selected
         */
        val correct = view.findViewById<TextView>(R.id.tvCorrect)
        val total = view.findViewById<TextView>(R.id.tvTotal)
        correct.text = args.grade.toString()
        total.text = args.noq.toString()

        // navigate to starting fragment to start the game again and press
        //new operations/difficulty
        val restartButton = view.findViewById<Button>(R.id.bRestart)
        restartButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_fragment3_to_fragment1)
        }
        return view
    }
}