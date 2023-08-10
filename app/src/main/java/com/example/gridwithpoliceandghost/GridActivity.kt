package com.example.gridwithpoliceandghost

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
\import java.util.Random


class GridActivity : Activity() {

    var gridAdapter = GenerateGridAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grid_generate_activity)


        val GRID_ROWS = intent.getIntExtra("rows", 0)
        val GRID_COLUMNS = intent.getIntExtra("columns", 0)

        regenerateGrid(GRID_ROWS, GRID_COLUMNS)

        findViewById<Button>(R.id.btn_generate).setOnClickListener { regenerateGrid(GRID_ROWS , GRID_COLUMNS) }

    }


    fun regenerateGrid(GRID_ROWS: Int , GRID_COLUMNS: Int) {
        val gridLayout: GridLayout = findViewById(R.id.gridLayout)

        var policeRow: Int
        var policeCol: Int
        var ghostRow: Int
        var ghostCol: Int
        val random = Random()

// Generate random positions for police and ghost
        policeRow = random.nextInt(GRID_ROWS)
        policeCol = random.nextInt(GRID_COLUMNS)

        do {
            ghostRow = random.nextInt(GRID_ROWS)
            ghostCol = random.nextInt(GRID_COLUMNS)
        } while (ghostRow == policeRow || ghostCol == policeCol)

        for (row in 0 until GRID_ROWS) {
            for (col in 0 until GRID_COLUMNS) {
                val cellView = View(this)
                val layoutParams = GridLayout.LayoutParams()
                layoutParams.rowSpec = GridLayout.spec(row)
                layoutParams.columnSpec = GridLayout.spec(col)
                layoutParams.setMargins(2, 2, 2, 2)
                layoutParams.height = 100
                layoutParams.width = 100
                cellView.setBackgroundColor(Color.GRAY) // Set your desired background color
                cellView.layoutParams = layoutParams
                gridLayout.addView(cellView)
            }
        }

// Create ImageView for police
        val policeImageView = ImageView(this)
        policeImageView.setImageResource(R.drawable.ic_police) // Set your police image resource
        val policeParams = GridLayout.LayoutParams()

        policeParams.rowSpec = GridLayout.spec(policeRow)
        policeParams.columnSpec = GridLayout.spec(policeCol)
        policeParams.height = 100
        policeParams.width = 100
        policeImageView.layoutParams = policeParams

// Create ImageView for ghost
        val ghostImageView = ImageView(this)
        ghostImageView.setImageResource(R.drawable.ic_ghost) // Set your ghost image resource
        ghostImageView.background
        val ghostParams = GridLayout.LayoutParams()
        ghostParams.rowSpec = GridLayout.spec(ghostRow)
        ghostParams.columnSpec = GridLayout.spec(ghostCol)
        ghostParams.height = 100
        ghostParams.width = 100
        ghostImageView.layoutParams = ghostParams

// Add image views to the grid layout
        gridLayout.addView(policeImageView)
        gridLayout.addView(ghostImageView)
    }

}