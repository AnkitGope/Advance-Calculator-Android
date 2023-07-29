package com.example.advancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.advancecalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAC.setOnClickListener {
            binding.tvNumbers.text=""
            binding.tvResult.text=""
        }
        binding.btn0.setOnClickListener {
            binding.tvNumbers.append("0")
        }
        binding.btn1.setOnClickListener {
            binding.tvNumbers.append("1")
        }
        binding.btn2.setOnClickListener {
            binding.tvNumbers.append("2")
        }
        binding.btn3.setOnClickListener {
            binding.tvNumbers.append("3")
        }
        binding.btn4.setOnClickListener {
            binding.tvNumbers.append("4")
        }
        binding.btn5.setOnClickListener {
            binding.tvNumbers.append("5")
        }
        binding.btn6.setOnClickListener {
            binding.tvNumbers.append("6")
        }
        binding.btn7.setOnClickListener {
            binding.tvNumbers.append("7")
        }
        binding.btn8.setOnClickListener {
            binding.tvNumbers.append("8")
        }
        binding.btn9.setOnClickListener {
            binding.tvNumbers.append("9")
        }
        binding.btnDecimal.setOnClickListener {
            binding.tvNumbers.append(".")
        }
        binding.btnPlus.setOnClickListener {
            binding.tvNumbers.append("+")
        }
        binding.btnMinus.setOnClickListener {
            binding.tvNumbers.append("-")
        }
        binding.btnMultiplication.setOnClickListener {
            binding.tvNumbers.append("*")
        }
        binding.btnDivide.setOnClickListener {
            binding.tvNumbers.append("/")
        }
        binding.btnPercentage.setOnClickListener {
            binding.tvNumbers.append("%")
        }
        binding.btnEquals.setOnClickListener {
            val expression =ExpressionBuilder(binding.tvNumbers.text.toString()).build()
            val result = expression.evaluate()
            val longResult= result.toLong()

            if(result ==longResult.toDouble() ){
                binding.tvResult.text= longResult.toString()

            }else{
                binding.tvResult.text= result.toString()
            }
        }







    }
}