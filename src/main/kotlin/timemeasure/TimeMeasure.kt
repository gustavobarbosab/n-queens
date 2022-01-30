package timemeasure

import java.util.concurrent.TimeUnit

object TimeMeasure {
    fun measure(timeReturned: TimeUnit, func: () -> Unit): Long {
        val startTime = System.nanoTime()
        func()
        val endTime = System.nanoTime()
        val totalTimeInNanoSeconds = endTime - startTime
        return timeReturned.convert(totalTimeInNanoSeconds, TimeUnit.NANOSECONDS)
    }
}