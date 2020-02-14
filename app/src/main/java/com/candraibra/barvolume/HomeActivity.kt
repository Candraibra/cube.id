package com.candraibra.barvolume

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.candraibra.barvolume.IntentExplicit.Companion.EXTRA_DATA
import com.candraibra.barvolume.IntentExplicit.Companion.EXTRA_PERSON

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var btnMove: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_width)
        btnCalculate = findViewById(R.id.btn_calculate)
        btnMove = findViewById(R.id.btn_pindah)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
        btnMove.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }


    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {
            try {

                val width = edtWidth.text.toString().trim()
                val length = edtLength.text.toString().trim()
                val height = edtHeight.text.toString().trim()

                val volume = (width.toDouble() * height.toDouble()) * length.toDouble()

                tvResult.text = volume.toString()

            } catch (e: Exception) {
                Toast.makeText(this, "Please fill the data", Toast.LENGTH_SHORT).show()
                Log.d("Exception", e.toString())
            }
        } else if (v.id == R.id.btn_pindah) {
            val moveIntent = Intent(this@HomeActivity, IntentExplicit::class.java)
            moveIntent.putExtra(EXTRA_DATA, tvResult.text)
            moveIntent.putExtra(EXTRA_PERSON, Person("Candra", 18, "canisanie@gmail.com"))
            startActivity(moveIntent)
        }
    }
}
