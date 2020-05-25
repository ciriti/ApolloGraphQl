package com.lastminute.kmp.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloExperimental
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.network.ApolloHttpNetworkTransport
import com.pd.UserQuery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

interface RemoteRepoGraphQl{
    suspend fun fetchUser(id: String): UserQuery.Data?
    fun fetchUserCB(
        id: String,
        success: (UserQuery.Data) -> Unit,
        error: (Throwable) -> Unit
    )
}

@ApolloExperimental
@ExperimentalCoroutinesApi
fun createRemoteRepoGraphQl(client : ApolloClient, scope : CoroutineScope) : RemoteRepoGraphQl = ApolloRemoteRepository(client, scope)

@ApolloExperimental
@ExperimentalCoroutinesApi
fun createRemoteRepoGraphQl(client : ApolloClient) : RemoteRepoGraphQl = ApolloRemoteRepository(client, MainScope())

@ApolloExperimental
@ExperimentalCoroutinesApi
fun createRemoteRepoGraphQl() : RemoteRepoGraphQl = ApolloRemoteRepository(createApolloClient(), MainScope())

@ApolloExperimental
@ExperimentalCoroutinesApi
fun createApolloClient() : ApolloClient = ApolloClient(
    networkTransport = ApolloHttpNetworkTransport(
        serverUrl = "http://192.168.1.106:4000/graphql",
        httpHeaders = mapOf(
            "Accept" to "application/json",
            "Content-Type" to "application/json",
            "Authorization" to "bearer"
        )
    )
)

@ApolloExperimental
@ExperimentalCoroutinesApi
private class ApolloRemoteRepository(
    val apolloClient : ApolloClient,
    val scope : CoroutineScope = MainScope()
) : RemoteRepoGraphQl{

    override suspend fun fetchUser(id: String): UserQuery.Data?{
        val userQuery = UserQuery(id = Input.optional(id))
        val response: Response<UserQuery.Data> = apolloClient.query(userQuery).execute().single()
            .apply { println(this) }
        return response.data
    }

    override fun fetchUserCB(
        id: String,
        success: (UserQuery.Data) -> Unit,
        error: (Throwable) -> Unit
    ){
        scope.launch {
            val userQuery = UserQuery(id = Input.optional(id))
            apolloClient
                .query(userQuery).execute().single().data
                ?.let(success)
                ?:error(RuntimeException("Result is null"))
        }
    }


}