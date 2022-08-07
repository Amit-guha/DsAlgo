package com.example.ds.stack

data class Status(
    val Message: String,
    val RecordCount: String,
    val Result: List<Result>,
    val Status: Int
)