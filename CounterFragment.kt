package com.example.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework.databinding.FragmentCounterBinding
import java.math.BigDecimal

class CounterFragment: Fragment() {
    private var _binding:FragmentCounterBinding? = null
    private val binding get() = requireNotNull(_binding){"View was destroyed"}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCounterBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            fun inputIsNotEmpty(): Boolean {

                var b = true
                if (btnNum1.text.toString().trim().isEmpty()) {
                    btnNum1.error = "Required"
                    b = false
                }
                if (btnNum2.text.toString().trim().isEmpty()) {
                    btnNum2.error = "Required"
                    b = false
                }
                return b
            }

            fun add() {
                if (inputIsNotEmpty()) {
                    val input1 = btnNum1.text.toString().trim().toBigDecimal()
                    val input2 = btnNum2.text.toString().trim().toBigDecimal()
                    txt.text = input1.add(input2).toString()
                }
            }

            fun substract() {
                if (inputIsNotEmpty()) {
                    val input1 = btnNum1.text.toString().trim().toBigDecimal()
                    val input2 = btnNum2.text.toString().trim().toBigDecimal()
                    txt.text = input1.subtract(input2).toString()
                }
            }

            fun multiply() {
                if (inputIsNotEmpty()) {
                    val input1 = btnNum1.text.toString().trim().toBigDecimal()
                    val input2 = btnNum2.text.toString().trim().toBigDecimal()
                    txt.text = input1.multiply(input2).toString()
                }
            }

            fun divide() {
                if (inputIsNotEmpty()) {
                    val input1 = btnNum1.text.toString().trim().toBigDecimal()
                    val input2 = btnNum2.text.toString().trim().toBigDecimal()
                    if (input2.compareTo(BigDecimal.ZERO) == 0) {
                        btnNum2.error = "Invalid input"
                    } else {
                        txt.text = input1.divide(input2).toString()
                    }
                }
            }


            btnDiv.setOnClickListener {
                divide()

            }
            btnMultiply.setOnClickListener {
                multiply()

            }
            btnPlus.setOnClickListener {
                add()

            }
            btnMinus.setOnClickListener {
                substract()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}