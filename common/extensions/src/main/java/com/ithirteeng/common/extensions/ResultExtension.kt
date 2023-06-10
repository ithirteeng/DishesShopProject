package com.ithirteeng.common.extensions

import android.util.Log

suspend fun <T> provideResult(execute: suspend () -> T): Result<T> {
    return try {
        Result.success(execute())
    } catch (e: Exception) {
        Log.e("ERROR", "cause: ", e)
        Result.failure(e)
    }
}