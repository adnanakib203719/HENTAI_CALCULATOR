package com.example.hentaicalculator
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Toast
import androidx.compose.ui.text.font.Typeface
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.example.hentaicalculator.R
import kotlinx.android.synthetic.main.activity_main.*

import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.error_tone)
        mediaPlayer?.start()
        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
            Toast.makeText(
                this@MainActivity, "All clear :   AHHHHHHHH",
                Toast.LENGTH_SHORT

            )                     .show()

            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }


        button_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()

        }
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_0.setOnClickListener {
            input.text = addToInputText("0")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_1.setOnClickListener {
            input.text = addToInputText("1")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_2.setOnClickListener {
            input.text = addToInputText("2")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_3.setOnClickListener {
            input.text = addToInputText("3")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_4.setOnClickListener {
            input.text = addToInputText("4")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_5.setOnClickListener {
            input.text = addToInputText("5")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_6.setOnClickListener {
            input.text = addToInputText("6")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_7.setOnClickListener {
            input.text = addToInputText("7")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_8.setOnClickListener {
            input.text = addToInputText("8")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_9.setOnClickListener {
            input.text = addToInputText("9")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_dot.setOnClickListener {
            input.text = addToInputText(".")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_division.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.start()
        }

        button_equals.setOnClickListener  {
            showResult()
            mediaPlayer = MediaPlayer.create(this,R.raw.result_tone)
            mediaPlayer?.start()

        }
    }


    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult()  {

        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                //  error message
                Toast.makeText(
                    this@MainActivity, "Error : There is nothing to answer ASSHOLE!!!",
                    Toast.LENGTH_SHORT

                )                     .show()

                output.text = "YAMETE  KUDASAI  !!!"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
                output.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f)

                mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
                mediaPlayer?.stop()
                mediaPlayer = MediaPlayer.create(this,R.raw.result_tone)
                mediaPlayer?.stop()
                mediaPlayer = MediaPlayer.create(this,R.raw.error_tone)
                mediaPlayer?.start()

            } else {
                //  result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
                mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
                mediaPlayer?.stop()

                mediaPlayer = MediaPlayer.create(this,R.raw.error_tone)
                mediaPlayer?.stop()
            }
        } catch (e: Exception) {
            //  error message


            output.text = "YAMETE KUDASAI !!!"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
            mediaPlayer = MediaPlayer.create(this,R.raw.button_tone)
            mediaPlayer?.stop()
            mediaPlayer = MediaPlayer.create(this,R.raw.result_tone)
            mediaPlayer?.stop()
            mediaPlayer = MediaPlayer.create(this,R.raw.error_tone)
            mediaPlayer?.start()

        }
    }
}