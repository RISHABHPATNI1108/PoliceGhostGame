package com.example.gridwithpoliceandghost

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_generate).setOnClickListener {

            var numRows = Integer.valueOf(findViewById<TextView>(R.id.et_row).text.toString())
            var numColumn = Integer.valueOf(findViewById<TextView>(R.id.et_column).text.toString())

            var intent = Intent(this, GridActivity::class.java);
            intent.putExtra("rows", numRows)
            intent.putExtra("columns", numColumn)
            startActivity(intent)
        }
    }

}