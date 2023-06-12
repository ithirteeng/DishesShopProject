package com.ithirteeng.common.cart.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ithirteeng.common.cart.data.dao.CartDao
import com.ithirteeng.common.cart.data.entity.CartEntity

@Database(entities = [CartEntity::class], version = 1)
abstract class CartDatabase : RoomDatabase() {
    abstract fun getCartDao(): CartDao
}