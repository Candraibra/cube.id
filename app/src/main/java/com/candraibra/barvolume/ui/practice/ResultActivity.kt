package com.candraibra.barvolume.ui.practice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.candraibra.barvolume.R

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_result"
        const val RESULT_CODE = 110
    }

    private lateinit var radioBtn: RadioGroup
    private lateinit var btnChoose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        radioBtn = findViewById(R.id.rg_number)
        btnChoose = findViewById(R.id.btn_choose)

        btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_choose) {
            if (radioBtn.checkedRadioButtonId != 0) {
                var value = 0
                when (radioBtn.checkedRadioButtonId) {

                    R.id.rb_50 -> value = 50

                    R.id.rb_100 -> value = 100

                    R.id.rb_150 -> value = 150

                    R.id.rb_200 -> value = 200

                }
                val resultItem = Intent()
                resultItem.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultItem)
                finish()
            }
        }
    }
}
