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

interface ApolloClient{
    suspend fun fetchData() : SearchQuery.Data?
    fun fetchDataCB(success : (SearchQuery.Data) -> Unit, error : (Throwable) -> Unit)
}

@ApolloExperimental
@ExperimentalCoroutinesApi
fun create(client : ApolloClient, scope : CoroutineScope) : com.lastminute.kmp.data.ApolloClient =
    ApolloClientImpl(client, scope)

@ApolloExperimental
@ExperimentalCoroutinesApi
fun create(client : ApolloClient) : com.lastminute.kmp.data.ApolloClient =
    ApolloClientImpl(client, MainScope())

@ApolloExperimental
@ExperimentalCoroutinesApi
fun create() : com.lastminute.kmp.data.ApolloClient =
    ApolloClientImpl(createApolloClient(), MainScope())

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

@ApolloExperimental
@ExperimentalCoroutinesApi
private class ApolloClientImpl(
    val apolloClient : ApolloClient,
    val scope : CoroutineScope = MainScope()
) : com.lastminute.kmp.data.ApolloClient {

    override suspend fun fetchData() : SearchQuery.Data?{
        val repositoriesQuery = SearchQuery()
        val response: Response<SearchQuery.Data> = apolloClient.query(repositoriesQuery).execute().single()
        return response.data
    }

    override fun fetchDataCB(success : (SearchQuery.Data) -> Unit, error : (Throwable) -> Unit){
        scope.launch {
            val repositoriesQuery = SearchQuery()
            apolloClient
                .query(repositoriesQuery).execute().single().data
                ?.let(success)
                ?:error(RuntimeException("Result is null"))
        }
    }


}