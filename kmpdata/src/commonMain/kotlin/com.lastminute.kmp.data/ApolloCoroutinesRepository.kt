package com.lastminute.kmp.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloExperimental
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.network.ApolloHttpNetworkTransport
import com.pd.SearchQuery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

interface RemoteRepoGraphQl{
    suspend fun fetchRepositories() : SearchQuery.Data?
    fun fetchRepositoriesCB(success : (SearchQuery.Data) -> Unit, error : (Throwable) -> Unit)
}

@ApolloExperimental
@ExperimentalCoroutinesApi
fun createRemoteRepoGraphQl(client : ApolloClient, scope : CoroutineScope) : RemoteRepoGraphQl = ApolloCoroutinesRepository(client, scope)

@ApolloExperimental
@ExperimentalCoroutinesApi
fun createRemoteRepoGraphQl(client : ApolloClient) : RemoteRepoGraphQl = ApolloCoroutinesRepository(client, MainScope())

@ApolloExperimental
@ExperimentalCoroutinesApi
fun createRemoteRepoGraphQl() : RemoteRepoGraphQl = ApolloCoroutinesRepository(createApolloClient(), MainScope())

@ApolloExperimental
@ExperimentalCoroutinesApi
fun createApolloClient() : ApolloClient = ApolloClient(
    networkTransport = ApolloHttpNetworkTransport(
        serverUrl = "http://ose-api-qa.nonprd.bravofly.intra/ose-api/graphql",
        httpHeaders = mapOf(
            "Accept" to "application/json",
            "Content-Type" to "application/json",
            "Authorization" to "bearer"
        )
    )
)

/**
 * An implementation of a [GitHubDataSource] that shows how we can use coroutines to make our apollo requests.
 */
@ApolloExperimental
@ExperimentalCoroutinesApi
private class ApolloCoroutinesRepository(
    val apolloClient : ApolloClient,
    val scope : CoroutineScope = MainScope()
) : RemoteRepoGraphQl{

    override suspend fun fetchRepositories() : SearchQuery.Data?{
        val repositoriesQuery = SearchQuery()
        val response: Response<SearchQuery.Data> = apolloClient.query(repositoriesQuery).execute().single()
        return response.data
    }

    override fun fetchRepositoriesCB(success : (SearchQuery.Data) -> Unit, error : (Throwable) -> Unit){
        scope.launch {
            val repositoriesQuery = SearchQuery()
            apolloClient
                .query(repositoriesQuery).execute().single().data
                ?.let(success)
                ?:error(RuntimeException("Result is null"))
        }
    }


}