package com.example.alifbee.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.alifbee.R
import com.example.alifbee.databinding.ActivityParentsLockBinding
import kotlin.random.Random

private lateinit var binding: ActivityParentsLockBinding

class ParentsLock : AppCompatActivity() {
    lateinit var top_title : TextView
    lateinit var back_img : ImageView
    var numb1 = Random.nextInt(10)
    var numb2= Random.nextInt(10)
    var numb3= Random.nextInt(10)
    var index :Int=0
    var theNum :Int=0
    var firstNum:Int=0
    var secondNum:Int=0
    var thirdNum:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParentsLockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        randomgen ()

        top_title = findViewById(R.id.tob_bar_text)
        back_img = findViewById(R.id.back_bu)
        top_title.text = resources.getString(R.string.parents_lock)
        back_img.setOnClickListener(){
            val intent = Intent(this@ParentsLock,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        val but0= binding.bu0
        val but1= binding.bu1
        val but2= binding.bu2
        val but3= binding.bu3
        val but4= binding.bu4
        val but5= binding.bu5
        val but6= binding.bu6
        val but7= binding.bu7
        val but8= binding.bu8
        val but9= binding.bu9
        val butdel= binding.bude

        but0.setOnClickListener(){
            theNum=0
            myCheck()
        }
        but1.setOnClickListener(){
            theNum=1
            myCheck()
        }
        but2.setOnClickListener(){
            theNum=2
            myCheck()
        }
        but3.setOnClickListener(){
            theNum=3
            myCheck()
        }
        but4.setOnClickListener(){
            theNum=4
            myCheck()
        }
        but5.setOnClickListener(){
            theNum=5
            myCheck()
        }
        but6.setOnClickListener(){
            theNum=6
            myCheck()
        }
        but7.setOnClickListener(){
            theNum=7
            myCheck()
        }
        but8.setOnClickListener(){
            theNum=8
            myCheck()
        }
        but9.setOnClickListener(){
            theNum=9
            myCheck()
        }
        butdel.setOnClickListener(){
            del()
        }
    }
    fun randomgen (){
        val myNumberList = HashMap<Int,String>()
        myNumberList.put(0,"Zero")
        myNumberList.put(1,"One")
        myNumberList.put(2,"Two")
        myNumberList.put(3,"Three")
        myNumberList.put(4,"Four")
        myNumberList.put(5,"Five")
        myNumberList.put(6,"Six")
        myNumberList.put(7,"Seven")
        myNumberList.put(8,"Eight")
        myNumberList.put(9,"Nine")
        binding.textnum.setText(myNumberList[numb1]+","+myNumberList[numb2]+","+myNumberList[numb3])
    }
    fun del(){
        binding.num1.setText("")
        binding.num2.setText("")
        binding.num3.setText("")
        index=0
    }
    fun myCheck(){
        index++
        when(index){
            1->{
                binding.num1.setText(theNum.toString())
                firstNum=theNum
            }
            2->{
                binding.num2.setText(theNum.toString())
                secondNum=theNum
            }
            3->{
                index=0
                binding.num3.setText(theNum.toString())
                thirdNum=theNum
                if(numb1==firstNum && numb2==secondNum && numb3 == thirdNum){
                    val intent = Intent(this@ParentsLock,MorebyAlifBee::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this,"The number you entered is incorrect",Toast.LENGTH_LONG).show()
                    Handler().postDelayed({
                        del()
                    },100)

                }

            }
        }

    }
}