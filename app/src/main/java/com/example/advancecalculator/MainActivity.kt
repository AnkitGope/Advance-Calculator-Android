package com.example.advancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.advancecalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var lastNumeric=false
    var stateError= false
    var lastDot=false

    lateinit var expression: Expression

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun setDigitClick(view: View) {
        if(stateError){
            binding.tvNumbers.text=(view as Button).text

            stateError= false
        }else{
            binding.tvNumbers.append((view as Button).text)
        }
        lastNumeric= true
        onAnswer()

    }


    fun setOperatorClick(view: View) {
        if(!stateError && lastNumeric){
            binding.tvNumbers.append((view as Button).text)
            lastDot =false
            lastNumeric=false
             onAnswer()

        }

    }


    fun setAllClearClick(view: View) {

        binding.tvNumbers.text=""
        binding.tvResult.text=""
        lastNumeric=false
        stateError= false
        lastDot= false

    }


    fun setBackspaceClick(view: View) {

        binding.tvNumbers.text=binding.tvResult.text.dropLast(1)

        try {
            val lastChar =binding.tvNumbers.text.toString().last()

            if(lastChar.isDigit()){
                onAnswer()
            }

        }catch (e: Exception){
            binding.tvResult.text=""
            Log.e("last char error",e.toString())

        }

    }


    fun setEqualClick(view: View) {

        onAnswer()
        binding.tvNumbers.text=binding.tvResult.text.toString().drop(1)
    }

    fun onAnswer(){
        if(lastNumeric &&  !stateError){

            val txt= binding.tvNumbers.text.toString()
            expression= ExpressionBuilder(txt).build()

            try {
                val result =expression.evaluate()
                binding.tvResult.text = "="+result.toString()
            }catch (exe: ArithmeticException){
                Log.e("evaluate the value ",exe.toString())
                binding.tvResult.text="Error"
                stateError = true
                lastNumeric =false
            }

        }
    }


}