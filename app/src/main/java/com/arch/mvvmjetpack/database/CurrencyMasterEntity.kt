package com.arch.mvvmjetpack.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyMasterEntity(
    @PrimaryKey val country: String,
    @ColumnInfo(name = "currencySymbol") val currencySymbol: String
)
