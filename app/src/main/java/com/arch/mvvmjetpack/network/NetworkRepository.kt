package com.arch.mvvmjetpack.network

import com.arch.mvvmjetpack.database.ChitsAppDataBase
import com.arch.mvvmjetpack.database.ChitsMasterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val handler: APIHandler,
    private val appDataBase: ChitsAppDataBase
) {

    fun addChitItems(entity: ChitsMasterEntity): Flow<BaseResult<Boolean, String>> {
        return flow {
            val id = appDataBase.chitMasterEntityDao().insertChittyMaster(entity)
            emit(BaseResult.Success(id > 0))
        }
    }
}