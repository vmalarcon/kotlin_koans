package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val dateHashDifference = (this.year * 10000 + this.month * 100 + this.dayOfMonth) - (other.year * 10000 + other.month * 100 + other.dayOfMonth)
        return Math.signum(dateHashDifference.toDouble()).toInt()
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(interval: TimeInterval): MyDate = addTimeIntervals(interval, 1)

operator fun MyDate.plus(ri: RepeatedTimeInterval): MyDate = addTimeIntervals(ri.ti, ri.n)

enum class TimeInterval {
    WEEK,
    YEAR,
    DAY
}

operator fun TimeInterval.times(mult: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, mult)

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterator<MyDate> {
    var current: MyDate = start

    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }
}

operator fun DateRange.contains(date: MyDate): Boolean = date >= start && date <= endInclusive

operator fun DateRange.rangeTo(toDate: MyDate): DateRange = DateRange(start, toDate)

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)