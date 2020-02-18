package com.candraibra.barvolume.practice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.candraibra.barvolume.R

class IntentExplicit : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
        const val EXTRA_PERSON = "EXTRA_PERSON"
        const val EXTRA_RESULT = "EXTRA_RESULT"

    }

    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_explicit)
        tvResult = findViewById(R.id.tv_result)
        val person = intent.getParcelableExtra(EXTRA_PERSON) as Person

//        val data = intent.getStringExtra(EXTRA_DATA)
        tvResult.text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age}"

    }
}
