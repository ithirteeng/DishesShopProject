package com.ithirteeng.common.network.common

import java.io.IOException

class NoConnectivityException : IOException() {

    private companion object {
        const val ERROR_CODE = 1309
    }

    fun code(): Int = ERROR_CODE

    override val message: String
        get() = "No Internet Connection"
}