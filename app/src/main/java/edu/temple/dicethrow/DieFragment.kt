package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DieFragment : Fragment() {

    private val DIESIDE = "sidenumber"

    lateinit var dieTextView: TextView

    private val dieViewModel: DieViewModel by lazy {
        ViewModelProvider(this)[DieViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            it.getInt(DIESIDE).run {
                dieViewModel.dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dieViewModel.currentRoll.observe(viewLifecycleOwner) {
            dieTextView.text = it.toString()
        }

        if (dieViewModel.currentRoll.value == 0) {
            dieViewModel.throwDie()
        }
    }

    fun throwDie() {
        dieViewModel.throwDie()
    }

    companion object {
        fun newInstance (sides: Int = 6) = DieFragment().apply{
            arguments = Bundle().apply{
                putInt(DIESIDE, sides)
            }
        }
    }
}