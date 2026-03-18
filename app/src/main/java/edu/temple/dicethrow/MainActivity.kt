package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView)== null) {


            val dieFragment = DieFragment.newInstance(20)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment.newInstance(20))
                .add(R.id.fragmentContainerView2, DieFragment.newInstance())
                .commit()

        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {

            supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView)?.run{
                    (this as DieFragment).throwDie()
                }

            supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView2)?.run{
                    (this as DieFragment).throwDie()
                }
        }
    }
}