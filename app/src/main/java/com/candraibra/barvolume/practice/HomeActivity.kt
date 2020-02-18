package com.candraibra.barvolume.practice

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.candraibra.barvolume.practice.IntentExplicit.Companion.EXTRA_DATA
import com.candraibra.barvolume.practice.IntentExplicit.Companion.EXTRA_PERSON
import com.candraibra.barvolume.R
import com.candraibra.barvolume.practice.ResultActivity.Companion.RESULT_CODE

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val STATE_RESULT = "state_result"
        const val REQUEST_CODE = 100
    }

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var btnMove: Button
    private lateinit var btnMoveResult: Button
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
        btnMoveResult = findViewById(R.id.btn_result)

        btnCalculate.setOnClickListener(this)
        btnMove.setOnClickListener(this)
        btnMoveResult.setOnClickListener(this)

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
        when (v.id) {
            R.id.btn_calculate -> {
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
            }
            R.id.btn_pindah -> {
                val moveIntent = Intent(this@HomeActivity, IntentExplicit::class.java)
                moveIntent.putExtra(EXTRA_DATA, tvResult.text)
                moveIntent.putExtra(EXTRA_PERSON,
                    Person(
                        "Candra",
                        18,
                        "canisanie@gmail.com"
                    )
                )
                startActivity(moveIntent)
            }
            R.id.btn_result -> {
                val moveResult = Intent(this@HomeActivity, ResultActivity::class.java)
                startActivityForResult(moveResult,
                    REQUEST_CODE
                )
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                val result = data?.getIntExtra(ResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasilnya adalah  $result"
            }
        }
    }
}
