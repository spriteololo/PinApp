package com.test.core_base.ui

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateTimeUtils {

    val EMPTY = Date(0L)

    private const val SNAPSHOT_DEFAULT_FORMAT = "MM_dd_yyyy hh:mm:ss"
    private const val DATE_DEFAULT_FORMAT = "MM/dd/yyyy"
    private const val TIME_DEFAULT_FORMAT = "hh:mm"
    private const val ISO8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    private const val DATE_TIME_DEFAULT_FORMAT = "$DATE_DEFAULT_FORMAT $TIME_DEFAULT_FORMAT z"

    private fun getDateFormat(format: String = DATE_TIME_DEFAULT_FORMAT): DateFormat {
        return SimpleDateFormat(format, Locale.getDefault())
            .also { sdf -> sdf.timeZone = TimeZone.getTimeZone("UTC") }
    }

    fun formatDateTime(date: Date): String {
        return getDateFormat().format(date)
    }

    fun formatTimeBefore(date: Date): String {
        val builder = StringBuilder()
        var tempDate = date.time
        val times = listOf(
            TimeUnit.DAYS.toMillis(365),
            TimeUnit.DAYS.toMillis(30),
            TimeUnit.DAYS.toMillis(1),
            TimeUnit.HOURS.toMillis(1),
            TimeUnit.MINUTES.toMillis(1),
            TimeUnit.SECONDS.toMillis(1)
        )
        val timesString = listOf("year", "month", "day", "hour", "minute", "second")


        times.forEachIndexed { index, long ->
            val temp: Long = tempDate / long
            tempDate -= temp * long
            if (temp > 0) {
                builder.append(temp).append(" ").append(timesString[index])
                    .append(if (temp != 1L) "s " else " ")
            }
        }
        return builder.apply {
            if (isBlank()) append("few seconds ")
        }.append("ago")
            .toString()
    }

    fun formatDate(date: Date): String {
        return getDateFormat(DATE_DEFAULT_FORMAT).format(date)
    }

    fun formatTime(date: Date): String {
        return getDateFormat(TIME_DEFAULT_FORMAT).format(date)
    }

    fun parseFromServerString(dateStr: String, dateFormat: String = ISO8601_FORMAT): Date? {
        return getDateFormat(dateFormat).parse(dateStr)
    }

    fun Date.parseToServerString(dateFormat: String = ISO8601_FORMAT): String {
        return getDateFormat(dateFormat).format(this)
    }

    fun parseFromSnapshotString(dateStr: String, dateFormat: String = SNAPSHOT_DEFAULT_FORMAT): Date? {
        return try {
            getDateFormat(dateFormat).parse(dateStr)
        } catch (e: ParseException) {
            null
        }
    }

    fun parseToSnapshotString(date: Date, dateFormat: String = SNAPSHOT_DEFAULT_FORMAT): String {
        return getDateFormat(dateFormat).format(date)
    }
}