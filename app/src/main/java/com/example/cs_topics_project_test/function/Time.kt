package com.example.cs_topics_project_test.function

class Time(hour: Int, min: Int, isAm: Boolean) {
    private var hour: Int = 0
    private val min: Int
    private var isAm: Boolean = false

    init {
        var hour = hour
        this.min = min % 60
        if (min > 60) {
            hour += min / 60
        }
        require(hour <= 24) { "Invalid Time entered" }
        this.hour = hour % 12
        this.isAm = hour < 12
    }

    fun getHour(): Int {
        return this.hour
    }

    fun getMin(): Int {
        return this.min
    }

    fun isAm(): Boolean {
        return this.isAm;
    }

    fun isPm(): Boolean {
        return !this.isAm;
    }

    override fun toString(): String {
        return hour.toString() + ":" + this.min
    }
}