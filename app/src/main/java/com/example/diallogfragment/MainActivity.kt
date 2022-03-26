package com.example.diallogfragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var flag: String
        val spinnerVal: Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("Sandwich", "Pizza")
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        /* val ratingTV : TextView = findViewById(R.id.TVrating)
        ratingTV.setOnClickListener{
            var dialog_var = SandwichDialogFragment()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
        }*/

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
                if (flag == "Sandwich") {
                    var dialog_var = SandwichDialogFragment()
                    dialog_var.show(supportFragmentManager, "Sandwich Dialog")

                } else {
                    var dialog_var = PizzaDialogFragment()
                    dialog_var.show(supportFragmentManager, "Pizza Dialog")
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
    fun receiveFeedback(feedback: String){
        val ratingTV : TextView = findViewById(R.id.TVrating)
        ratingTV.text = feedback;

    }
}