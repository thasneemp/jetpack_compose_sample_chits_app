package com.arch.mvvmjetpack.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface ChitsMasterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertChittyMaster(chitsMasterEntity: ChitsMasterEntity): Long
}