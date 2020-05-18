package com.lastminute.kmp.data.localdatasource

import com.arrow.core.algebric.MpTry
import com.lastminute.kmp.data.MainScope
import com.lastminute.kmp.data.remotedatasource.Destination
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

interface LocalDataSource {
    suspend fun getDestinations(): MpTry<List<Destination>>
    companion object
}

fun createLocalDataSource() : LocalDataSource = LocalDataSourceImpl()

private class LocalDataSourceImpl : LocalDataSource {
    override suspend fun getDestinations(): MpTry<List<Destination>> {

        // TODO
        return  MpTry.Failure(RuntimeException())
    }
    private val scope by lazy { MainScope() }
}