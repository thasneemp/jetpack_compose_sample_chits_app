package com.arch.mvvmjetpack.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChitsMasterEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "currencyId") val currencyId: Int?,
    @ColumnInfo(name = "startDate") val startDate: String?,
    @ColumnInfo(name = "endDate") val endDate: String?,
    @ColumnInfo(name = "drawDate") val drawDate: String?,
    @ColumnInfo(name = "drawAmount") val drawAmount: String?,
    @ColumnInfo(name = "lastPaymentDate") val lastPaymentDate: String?,
    @ColumnInfo(name = "instalment") val instalment: String?,
)
