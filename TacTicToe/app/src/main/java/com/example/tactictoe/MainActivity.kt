package com.example.tactictoe

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var status = false
        val _0_0: ImageView = findViewById(R.id._0_0)
        val _0_1: ImageView = findViewById(R.id._0_1)
        val _0_2: ImageView = findViewById(R.id._0_2)
        val _1_0: ImageView = findViewById(R.id._1_0)
        val _1_1: ImageView = findViewById(R.id._1_1)
        val _1_2: ImageView = findViewById(R.id._1_2)
        val _2_0: ImageView = findViewById(R.id._2_0)
        val _2_1: ImageView = findViewById(R.id._2_1)
        val _2_2: ImageView = findViewById(R.id._2_2)
        val reset:Button = findViewById(R.id.Reset)

        val textView: TextView = findViewById(R.id.textview)
        var board = Array(3) { Array(3) { "-" } }
        var turn = false

        reset.setOnClickListener(View.OnClickListener {
            val ids = ArrayList<ImageView> ()
            ids.addAll(listOf(_0_0,_0_1,_0_2,_1_0,_1_1,_1_2,_2_0,_2_1,_2_2))

            for (i in 0 until ids.size) {
                ids[i].setImageResource(R.color.black)
                ids[i].isVisible = true
            }

            turn = false
            status = false

        })

        fun checkWin() {
            val xAxis = ArrayList<Int>()
            val yAxis = ArrayList<Int>()
            xAxis.addAll(listOf(0, 0, 0, 1, 2, 2, 2, 1, 0))
            yAxis.addAll(listOf(0, 1, 2, 2, 2, 1, 0, 0, 0))

            if ((board[1][1] == board[2][2]) and (board[2][2] == board[0][0]) and (board[0][0] != "-")) {
                status = true
            } else {
                for (i in 0 until xAxis.size step 2) {
                    if (i+1 >= xAxis.size) {
                        return
                    }

                    val x1 = board[xAxis[i]][yAxis[i]]
                    val x2 = board[xAxis[i+1]][yAxis[i+1]]
                    val x3 = board[xAxis[i+2]][yAxis[i+2]]

                    println("${x1},${x2},${x3}")
                    if (x1 == "-") {
                        return
                    }
                    if ((x1 == x2) and (x2 == x3)) {
                        status = true
                    }
                }
            }

            if(status) {

                val ids = ArrayList<ImageView> ()
                ids.addAll(listOf(_0_0,_0_1,_0_2,_1_0,_1_1,_1_2,_2_0,_2_1,_2_2))
                for (i in 0 until ids.size) {
                    ids[i].isVisible = false
                }
                if(!turn) {
                    textView.text = "Player two is Winner"
                }
                else {
                    textView.text = "Player one is Winner"
                }
            }
        }

        _0_0.setOnClickListener(View.OnClickListener {
            if (board[0][0] == "-") {
                if (turn) {
                    board[0][0] = "o"
                    turn = false
                    _0_0.setImageResource(R.drawable.o)
                } else {
                    board[0][0] = "x"
                    turn = true
                    _0_0.setImageResource(R.drawable.x)
                }
                print("Registering:")
                println(board[0][0])
            }
            checkWin()
        })

        _0_1.setOnClickListener(View.OnClickListener {
            if (board[0][1] == "-") {
                if (turn) {
                    board[0][1] = "o"
                    turn = false
                    _0_1.setImageResource(R.drawable.o)

                } else {
                    board[0][1] = "x"
                    turn = true
                    _0_1.setImageResource(R.drawable.x)
                }
                print("Registering:")
                println(board[0][1])
            }
            checkWin()
        })

        _0_2.setOnClickListener(View.OnClickListener {
            if (board[0][2] == "-") {

                if (turn) {
                    board[0][2] = "o"
                    turn = false
                    _0_2.setImageResource(R.drawable.o)
                } else {
                    board[0][2] = "x"
                    turn = true
                    _0_2.setImageResource(R.drawable.x)
                }
                print("Registering:")
                println(board[0][2])
            }
            checkWin()
        })

        _1_0.setOnClickListener(View.OnClickListener {
            if (board[1][0] == "-") {
                if (turn) {
                    board[1][0] = "o"
                    turn = false
                    _1_0.setImageResource(R.drawable.o)
                } else {
                    board[1][0] = "x"
                    turn = true
                    _1_0.setImageResource(R.drawable.x)
                }
                print("Registering:")
                println(board[1][0])
            }
            checkWin()
        })

        _1_1.setOnClickListener(View.OnClickListener {
            if (board[1][1] == "-") {
                if (turn) {
                    board[1][1] = "o"
                    turn = false
                    _1_1.setImageResource(R.drawable.o)

                } else {
                    board[1][1] = "x"
                    turn = true
                    _1_1.setImageResource(R.drawable.x)

                }
                print("Registering:")
                println(board[1][1])
            }
            checkWin()
        })

        _1_2.setOnClickListener(View.OnClickListener {
            if (board[1][2] == "-") {
                if (turn) {
                    board[1][2] = "o"
                    turn = false
                    _1_2.setImageResource(R.drawable.o)

                } else {
                    board[1][2] = "x"
                    turn = true
                    _1_2.setImageResource(R.drawable.x)
                }
                print("Registering:")
                println(board[1][2])
            }
            checkWin()
        })

        _2_0.setOnClickListener(View.OnClickListener {
            if (board[2][0] == "-") {
                if (turn) {
                    board[2][0] = "o"
                    turn = false
                    _2_0.setImageResource(R.drawable.o)
                } else {
                    board[2][0] = "x"
                    turn = true
                    _2_0.setImageResource(R.drawable.x)
                }
                print("Registering:")
                println(board[2][0])
            }
            checkWin()
        })

        _2_1.setOnClickListener(View.OnClickListener {
            if (board[2][1] == "-") {
                if (turn) {
                    board[2][1] = "o"
                    turn = false
                    _2_1.setImageResource(R.drawable.o)

                } else {
                    board[2][1] = "x"
                    turn = true
                    _2_1.setImageResource(R.drawable.x)
                }
                print("Registering:")
                println(board[2][1])
            }
            checkWin()
        })

        _2_2.setOnClickListener(View.OnClickListener {
            if (board[2][2] == "-") {
                if (turn) {
                    board[2][2] = "o"
                    turn = false
                    _2_2.setImageResource(R.drawable.o)

                } else {
                    board[2][2] = "x"
                    turn = true
                    _2_2.setImageResource(R.drawable.x)

                }
                print("Registering:")
                println(board[2][2])
            }
            checkWin()
        })


    }
}