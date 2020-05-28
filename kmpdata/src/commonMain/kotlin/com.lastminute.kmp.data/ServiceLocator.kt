package com.lastminute.kmp.data

import com.apollographql.apollo.api.ApolloExperimental
import com.lastminute.kmp.data.deal.createDealsUseCase
import com.lastminute.kmp.data.localdatasource.createLocalDataSource
import com.lastminute.kmp.data.remotedatasource.createRemoteDataSource
import com.lastminute.kmp.data.service.createDealsService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.native.concurrent.ThreadLocal

// Uncaught Kotlin exception: kotlin.native.concurrent.InvalidMutabilityException:
// mutation attempt of frozen kotlinx.atomicfu.AtomicRef@a6ef28
@ThreadLocal
object ServiceLocatorShared{
    val uc = createDealsUseCase(
        dealsService = createDealsService(
            remoteDataSource = createRemoteDataSource(),
            localDataSource = createLocalDataSource()
        ),
        dealsMapper = { it }
    )

    @ApolloExperimental
    @ExperimentalCoroutinesApi
    val graph = create()
}