package com.example.cs_topics_project_test.function

class Date(date: Int, month: Int, year: Int) {
    private val date: Int
    private val month: Int
    private val year: Int

    init {
        var date = date
        var month = month
        if (date > 31) {
            val mul = date / 31
            month += mul
            date %= 31
        }
        this.date = date
        this.month = month
        this.year = year
    }

    override fun toString(): String {
        return "$month/$date/$year"
    }
}