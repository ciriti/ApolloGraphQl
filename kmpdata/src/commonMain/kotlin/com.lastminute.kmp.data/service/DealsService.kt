package com.lastminute.kmp.data.service

import com.arrow.core.algebric.MpTry
import com.arrow.core.algebric.orElse
import com.lastminute.kmp.data.localdatasource.LocalDataSource
import com.lastminute.kmp.data.remotedatasource.Destination
import com.lastminute.kmp.data.remotedatasource.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

interface DealsService {
    suspend fun getDestinations(): MpTry<List<Destination>>
    companion object
}

fun createDealsService(
        localDataSource : LocalDataSource,
        remoteDataSource: RemoteDataSource
) : DealsService = DealsServiceImpl(localDataSource, remoteDataSource)

fun createDealsService(
        localDataSource : LocalDataSource,
        remoteDataSource: RemoteDataSource,
        scope : CoroutineScope
) : DealsService = DealsServiceImpl(localDataSource, remoteDataSource)

private class DealsServiceImpl(
        private val localDataSource : LocalDataSource,
        private val remoteDataSource: RemoteDataSource
) : DealsService{
    override suspend fun getDestinations(): MpTry<List<Destination>> = coroutineScope {
        localDataSource
            .getDestinations()
            .orElse { remoteDataSource.getDestinations()}
    }
}