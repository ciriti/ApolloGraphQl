package com.lastminute.kmp.data.remotedatasource

import com.arrow.core.algebric.MpTry
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

@Serializable
internal data class DestinationResponse(
        val destinationId: Int?,
        val destinationName: String?,
        val image: String?,
        val price: PriceResponse?,
        val searchUrl: String?,
        val startDate: String?,
        val timePeriod: String?
)

@Serializable
internal data class PriceResponse (
        val amount: Double?,
        val currency: String?
)

data class Destination(
        val destinationId: Int,
        val destinationName: String,
        val image: String,
        val price: Price,
        val searchUrl: String,
        val startDate: String,
        val timePeriod: String
)

data class Price (
        val amount: Double,
        val currency: String
)

@kotlinx.serialization.UnstableDefault
fun<T> mapperList(t : KSerializer<T>): suspend (HttpResponse) -> MpTry<List<T>> =
    { httpResponse : HttpResponse -> httpResponse.parseListJson(t)  }

@kotlinx.serialization.UnstableDefault
suspend fun <T> HttpResponse.parseListJson(kSerializer: KSerializer<T>): MpTry<List<T>> {
    return MpTry {
        Json.parse(
            kSerializer.list,
            readText()
        )
    }
}

fun <T, R> List<T>.filterResponseValues(dtoMapper: (T) -> R): MutableList<R> {
    val initialList: List<MpTry<R>> = this.map {
        MpTry {
            dtoMapper(
                it
            )
        }
    }
    val filteredDestinations: MutableList<R> =
            initialList.fold(mutableListOf<R>()) { acc, item ->
                if (item is MpTry.Success) {
                    item.map { acc.add(it) }
                }
                acc
            }
    return filteredDestinations
}