package com.ithirteeng.common.helpers

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object DateHelper {
    @SuppressLint("SimpleDateFormat")
    fun getDateInFullFormat(): String {
        val simpleDateFormat = SimpleDateFormat("dd MMMM, yyyy")
        return simpleDateFormat.format(Date())
    }
}