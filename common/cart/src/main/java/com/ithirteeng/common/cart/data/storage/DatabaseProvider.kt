package com.ithirteeng.common.cart.data.storage

import android.app.Application
import androidx.room.Room

fun provideDatabase(application: Application): CartDatabase {
    return Room.databaseBuilder(
        application, CartDatabase::class.java,
        "cart_database"
    ).build()
}