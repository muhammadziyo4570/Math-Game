package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var number1 = 0
    var number2 = 0
    var amal = 0
    var javob = 0

    var userJavob = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random()

        btn_1.setOnClickListener {
            userJavob = edt_1.text.toString().toInt()

            if (userJavob == javob){
                Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }

            edt_1.text.clear()

            random()
        }

    }

    fun random(){
        number1 = Random().nextInt(20)
        number2 = Random().nextInt(20)

        amal = Random().nextInt(4)

        ekrangaChiqar()
    }

    fun ekrangaChiqar(){
        when(amal){
            0 ->{
                javob = number1 + number2
                txt_1.text = "$number1 + $number2 = "
            }
            1->{
                javob = number1 - number2
                txt_1.text = "$number1 - $number2 = "
            }
            2->{
                javob = number1 * number2
                txt_1.text = "$number1 * $number2 = "
            }
            3->{
                try {
                    javob = number1 / number2
                    txt_1.text = "$number1 / $number2 = "
                }catch (e:Exception){
                    random()
                }
            }
        }
    }
}