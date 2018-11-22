package com.kotlin.widget.buttonandedittext

import android.app.ProgressDialog
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var mybutton: Button
    lateinit var MYTEXT: TextView
    lateinit var mybutton2: Button
    lateinit var editText: EditText
    lateinit var myradiogroup: RadioGroup
    lateinit var mylayouyt: LinearLayout

    lateinit var CheckButton: Button

    lateinit var checkBox1: CheckBox
    lateinit var checkBox2: CheckBox

    lateinit var myrating: RatingBar
    lateinit var ratingCButton: Button

    lateinit var myspinner: Spinner

    lateinit var myswitch: Switch

    lateinit var showpdialog: Button
    lateinit var prog: ProgressDialog

    lateinit var spinneradap: ArrayAdapter<String>

    lateinit var myAutoCompleteTextView: AutoCompleteTextView
    lateinit var autocompleteadap: ArrayAdapter<String>

    lateinit var textSwitcher: TextSwitcher
    lateinit var previousbtn: Button
    lateinit var nextbtn: Button
    var positon: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MYTEXT = findViewById(R.id.textview)
        mybutton = findViewById(R.id.button)
        mybutton2 = findViewById(R.id.buttontwo)
        editText = findViewById(R.id.myedittext)
        myradiogroup = findViewById(R.id.radiogroup)
        mylayouyt = findViewById(R.id.myln)
        CheckButton = findViewById(R.id.checkbutton)
        checkBox1 = findViewById(R.id.rice)
        checkBox2 = findViewById(R.id.fish)
        myrating = findViewById(R.id.ratingbar)
        ratingCButton = findViewById(R.id.ratingcheck)
        myspinner = findViewById(R.id.spinner)
        myswitch = findViewById(R.id.myswitch)
        showpdialog = findViewById(R.id.pdialog)
        myAutoCompleteTextView = findViewById(R.id.autocompletetextView)
        textSwitcher = findViewById(R.id.textswitcher)
        previousbtn = findViewById(R.id.prev)
        nextbtn = findViewById(R.id.next)


///////////////////////////////////////////////////////////////////////////////////
        mybutton.setOnClickListener()
        {
            MYTEXT.text = "NAYEEM SHIDDIKI ABIR"
        }
/////////////////////////////////////////////////////////////////////////////////
        MYTEXT.setOnClickListener()
        {
            Toast.makeText(this@MainActivity,"THIS IS MY TEXT",Toast.LENGTH_LONG).show()
        }

////////////////////////////////////////////////////////////////////////////////
        mybutton2.setOnClickListener()
        {
            Toast.makeText(this@MainActivity,editText.text.toString(),Toast.LENGTH_LONG).show()
        }

/////////////////////////////////////////////////////////////////////////////////
        myradiogroup.setOnCheckedChangeListener { group, checkedId ->


            when(checkedId)
            {

                R.id.red->
                {
                    mylayouyt.setBackgroundColor(Color.parseColor("#FFFD0206"))
                }

                R.id.green->
                {
                    mylayouyt.setBackgroundColor(Color.parseColor("#FF2EBA2B"))
                }
                R.id.blue->
                {
                    mylayouyt.setBackgroundColor(Color.parseColor("#FF48A6DC"))
                }
            }
        }
////////////////////////////////////////////////////////////////////////////////
        CheckButton.setOnClickListener{

            if (checkBox1.isChecked == true)
            {
                Toast.makeText(this@MainActivity, "You Clicked in Rice",Toast.LENGTH_SHORT).show()
            }

            else if (checkBox2.isChecked)
            {
                Toast.makeText(this@MainActivity, "You Clicked in Fish",Toast.LENGTH_SHORT).show()
            }

            else if (checkBox2.isChecked == true && checkBox1.isChecked == true)
            {
                Toast.makeText(this@MainActivity, "You Clicked in Rice+Fish",Toast.LENGTH_SHORT).show()
            }

            else
            {
                Toast.makeText(this@MainActivity, "Nothing is Selected",Toast.LENGTH_SHORT).show()

            }

        }
/////////////////////////////////////////////////////////////////////
        ratingCButton.setOnClickListener {

            var rtv = myrating.rating
            Toast.makeText(this@MainActivity, "Your Rate is:- "+rtv, Toast.LENGTH_SHORT).show()
        }
/////////////////////////////////////////////////////////////////////

        val food = resources.getStringArray(R.array.foodlist)
        spinneradap = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item,food)
        myspinner.adapter = spinneradap

        myspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                val data = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Your Clicked on:- "+data, Toast.LENGTH_SHORT).show()


            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
////////////////////////////////////////////////////////////////////
        myswitch.setOnClickListener {

            if (myswitch.isChecked)
            {
                Toast.makeText(this@MainActivity, "Swith is ON Now", Toast.LENGTH_SHORT).show()

            }
            else
            {
                Toast.makeText(this@MainActivity, "Swith is OFF Now", Toast.LENGTH_SHORT).show()

            }
        }
//////////////////////////////////////////////////////////////////
        showpdialog.setOnClickListener {

            prog = ProgressDialog(this@MainActivity)
            prog.setTitle("Loading....")
            prog.setCancelable(true)
            prog.setMessage("Please wait,, data retriving from server...")
            prog.show()

        }
/////////////////////////////////////////////////////////////////
        val fruits = arrayOf("Mango","Apple")
        autocompleteadap = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1,fruits)
        myAutoCompleteTextView.setAdapter(autocompleteadap)

/////////////////////////////////////////////////////////////////////
        val textArrays = arrayOf(

            "Nayeem Shiddiki Abir",
            "Mohaimanul Chowdhury Ramim",
            "Saif Ullah",
            "Anwar Hossain Bappy",
            "Imran Hossain",
            "Saida Tasneem Shanta",
            "Asrafunessa",
            "Nasrin Sultana Rova"

        )

        textSwitcher.setFactory(object: ViewSwitcher.ViewFactory {

            override fun makeView(): View {

                val tv = TextView(this@MainActivity)
                tv.textSize = 20F
                tv.gravity = Gravity.CENTER
                return tv
            }
        })
        /////

        prev.setOnClickListener {

            if (positon > 0)
            {
                positon = positon -1
                textSwitcher.setText(textArrays[positon])
            }

        }

        next.setOnClickListener {

            if (positon < textArrays.size-1)
            {
                positon = positon+1
                textSwitcher.setText(textArrays[positon])

            }

        }


    }

}
