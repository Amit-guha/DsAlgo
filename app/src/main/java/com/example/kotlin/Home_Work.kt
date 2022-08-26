package com.example.kotlin

fun main() {
    println(isUpperCase(ch = '9'))
}

fun isUpperCase(ch : Char) = ch in '0'..'9'