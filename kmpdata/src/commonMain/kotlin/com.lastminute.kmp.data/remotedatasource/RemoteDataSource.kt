package com.lastminute.kmp.data.remotedatasource

import com.arrow.core.algebric.MpTry
import com.lastminute.kmp.data.NetConfig
import com.lastminute.kmp.data.NetConfigImpl
import com.lastminute.kmp.data.clientEngine
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLProtocol
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json

interface RemoteDataSource {
    suspend fun getDestinations(): MpTry<List<Destination>>
    companion object
}

fun createRemoteDataSource(): RemoteDataSource = RemoteDataSourceImpl()

fun RemoteDataSource.Companion.create(
        clientHttpEngine: HttpClientEngine,
        netConfig: NetConfig = NetConfigImpl
): RemoteDataSource = RemoteDataSourceImpl(clientHttpEngine = clientHttpEngine, netConfig =  netConfig)

private class RemoteDataSourceImpl(
    clientHttpEngine: HttpClientEngine = clientEngine,
    val mapper4List : suspend (HttpResponse) -> MpTry<List<DestinationResponse>> = mapperList(DestinationResponse.serializer()),
    private val netConfig: NetConfig = NetConfigImpl
) : RemoteDataSource {

    private val client: HttpClient = HttpClient(clientHttpEngine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json.nonstrict)
        }
    }

    override suspend fun getDestinations(): MpTry<List<Destination>> = coroutineScope {
        val response = client.get<HttpResponse> {
            url {
                protocol = URLProtocol.HTTPS
                host = netConfig.url
                encodedPath = netConfig.pathDeals
            }
        }
        when (response.status.value) {
            HttpStatusCode.OK.value -> {
                val response = mapper4List(response)
                response.map {
                    it.filterResponseValues<DestinationResponse, Destination>() { it2 -> it2.toDestination() }
                }

            }
            else -> {
                throw RuntimeException("${response.status.value} ${response.status.description}")
            }
        }
    }
}