package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    /* println(
         isValidSudoku(
             board = arrayOf(
                 charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                 charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                 charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                 charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                 charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                 charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                 charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                 charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                 charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
             )
         )
     )*/

    println(
        isValidSudoku(
            arrayOf(
                charArrayOf('.', '.', '4', '.', '.', '.', '6', '3', '.'),
                charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                charArrayOf('5', '.', '.', '.', '.', '.', '.', '9', '.'),
                charArrayOf('.', '.', '.', '5', '6', '.', '.', '.', '.'),
                charArrayOf('4', '.', '3', '.', '.', '.', '.', '.', '1'),
                charArrayOf('.', '.', '.', '7', '.', '.', '.', '.', '.'),
                charArrayOf('.', '.', '.', '5', '.', '.', '.', '.', '.'),
                charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
            )
        )
    )
}

@RequiresApi(Build.VERSION_CODES.N)
fun isValidSudoku(board: Array<CharArray>): Boolean {

    for (i in board.indices) {
        val hashMap = HashMap<Char, Int>()
        for (j in board[i].indices) {
            val value = board[i][j]
            if (value != '.') {
                if (hashMap.containsKey(value)) {
                    return false
                }
                hashMap[value] = 1
            }
        }
    }

    for (col in 0 until 9) {
        val hashMap = HashMap<Char, Int>()
        for (row in 0 until 9) {
            val value = board[row][col]
            if (value != '.') {
                if (hashMap.containsKey(value)) {
                    println("Duplicate found at column $col (value=$value)")
                    return false
                }
                hashMap[value] = 1
            }
        }
    }


    outer@ for (boxRow in 0 until 9 step 3) {
        for (boxCol in 0 until 9 step 3) {
            val hashMap = HashMap<Char, Int>()

            for (r in boxRow until boxRow + 3) {
                for (c in boxCol until boxCol + 3) {
                    val value = board[r][c]
                    if (value != '.') {
                        if (hashMap.containsKey(value)) {
                            return false
                        }
                        hashMap[value] = 1
                    }
                }
            }
        }
    }

    return true
}