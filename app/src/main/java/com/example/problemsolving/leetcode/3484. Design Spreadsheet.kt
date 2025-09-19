package com.example.problemsolving.leetcode

class Spreadsheet(rows: Int) {
    val hashMap = HashMap<String, Int>()

    init {
        for (i in 0 until rows) {
            for (j in 'A'..'Z') {
                hashMap["$j${i + 1}"] = 0
            }
        }
    }

    fun getHashMap() {
        println(hashMap)
    }

    fun setCell(cell: String, value: Int) {
        hashMap[cell] = value
    }

    fun resetCell(cell: String) {
        hashMap[cell] = 0
    }

    fun getValue(formula: String): Int {
        val formula = formula.split("+")
        val mappedFormula = formula.map { it.replace("=", "") }

        val isFirstValueLetter = mappedFormula[0].any { it.isLetter() }
        val isSecondValueLetter = mappedFormula[1].any { it.isLetter() }

        println(isFirstValueLetter)
        println(isSecondValueLetter)

        return if (isFirstValueLetter && isSecondValueLetter) {
            hashMap[mappedFormula[0]]!! + hashMap[mappedFormula[1]]!!
        } else if (isFirstValueLetter) {
            hashMap[mappedFormula[0]]!! + mappedFormula[1].toInt()
        } else if (isSecondValueLetter) {
            mappedFormula[0].toInt() + hashMap[mappedFormula[1]]!!
        } else {
            mappedFormula[0].toInt() + mappedFormula[1].toInt()
        }
    }

}

fun main() {
    val spreadsheet = Spreadsheet(3)
    //spreadsheet.getHashMap()
    // println(spreadsheet.getValue("=5+7")) // returns 12 (5+7)
    println(spreadsheet.getValue("=O126+10272")) // returns 12 (5+7)
    spreadsheet.setCell("A1", 10); // sets A1 to 10
    println(spreadsheet.getValue("=A1+6")) // returns 16 (10+6)
    spreadsheet.setCell("B2", 15); // sets B2 to 15
    println(spreadsheet.getValue("=A1+B2")) // returns 25 (10+15)
    spreadsheet.resetCell("A1"); // resets A1 to 0
    println(spreadsheet.getValue("=A1+B2")) // returns 15 (0+15)
    spreadsheet.getHashMap()
}