package com.arch.mvvmjetpack.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ChitsMasterEntity::class, CurrencyMasterEntity::class], version = 1)
abstract class ChitsAppDataBase : RoomDatabase() {
    abstract fun chitMasterEntityDao(): ChitsMasterDao
    abstract fun currencyMasterEntity(): CurrencyMasterDao
}