package com.lastminute.kmp.data.remotedatasource

import com.lastminute.kmp.data.ServiceLocatorShared
import com.lastminute.kmp.data.createApolloClient
import com.lastminute.kmp.data.createRemoteRepoGraphQl
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Test

class ApiMpTest {

    @Test
    fun test_api() = runBlocking<Unit> {
        val api = createRemoteDataSource()
        api.getDestinations().map { println(it) }
    }

//    @Test - you have to be in the VPN to get this res
    fun test_api2() = runBlocking<Unit> {
        val res = withContext(coroutineContext) { createRemoteRepoGraphQl(createApolloClient()).fetchUser() }
        println(res)
    }

    @Test
    fun test_ktor() = runBlocking<Unit>{
        val res = ServiceLocatorShared.uc.getDestinations()
        println(res)
    }

}