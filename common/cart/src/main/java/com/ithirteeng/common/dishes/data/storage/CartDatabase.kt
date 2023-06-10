package com.ithirteeng.common.dishes.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ithirteeng.common.dishes.data.dao.CartDao
import com.ithirteeng.common.dishes.data.entity.CartEntity

@Database(entities = [CartEntity::class], version = 1)
abstract class CartDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}