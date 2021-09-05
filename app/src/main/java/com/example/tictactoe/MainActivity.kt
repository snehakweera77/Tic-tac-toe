package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun btnClick(view: View) {
        val btnSelected: Button = view as Button
        var cellId = 0
        when (btnSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button3 -> cellId = 2
            R.id.button2 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }
        playGame(cellId, btnSelected)
    }
    fun playGame(cellId: Int, btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
        }
        btnSelected.isEnabled = false
        autoPlay()
        checkWinner()
    }

    private fun autoPlay() {
        var emptyCells = ArrayList<Int>()
        for (cellId in 1..9) {
            if (!player1.contains(cellId) && !player2.contains(cellId))
                emptyCells.add(cellId)
        }
        var r = Random()
        val randomIndex: Int = r.nextInt(emptyCells.size)
        val cellId:Int = emptyCells[randomIndex]
        var btnSelected:Button = when(cellId) {
            1 -> button1
            2 -> button2
            3 -> button3
            4 -> button4
            5 -> button5
            6 -> button6
            7 -> button7
            8 -> button8
            9 -> button9
            else -> button1
        }
        playGame(cellId, btnSelected)
    }

    private fun checkWinner() {
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2
        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2
        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2
        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2
        //diag 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2
        //diag 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2

        if (winner == 1)
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()

    }
}