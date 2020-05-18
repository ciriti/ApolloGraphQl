package com.lastminute.kmp.data.remotedatasource

import com.arrow.core.algebric.MpTry

internal fun DestinationResponse.toDestination() = Destination(
        destinationId = checkNotNull(destinationId) { "destinationId cannot be null!!!" },
        destinationName = checkNotNull(destinationName) { "destinationId[$destinationId] destinationName cannot be null!!!" },
        image = checkNotNull(image) { "destinationId[$destinationId] image cannot be null!!!" },
        price = checkNotNull(this.price) { "destinationId[$destinationId] price cannot be null!!!" }.toPrice(),
        searchUrl = checkNotNull(searchUrl) { "destinationId[$destinationId] searchUrl cannot be null!!!" },
        startDate = checkNotNull(startDate) { "destinationId[$destinationId] startDate cannot be null!!!" },
        timePeriod = checkNotNull(timePeriod) { "destinationId[$destinationId] timePeriod cannot be null!!!" }
)

internal fun PriceResponse.toPrice() = Price(
        amount = checkNotNull(amount) { "amount cannot be null!!!" },
        currency = checkNotNull(currency) { "currency amount cannot be null!!!" }
)

private fun<T, R> filterResponseValues(l: List<T>, dtoMapper : (T) -> R ) : MutableList<R>{
    val initialList: List<MpTry<R>> = l.map {
        MpTry {
            dtoMapper(
                it
            )
        }
    }
    val filteredDestinations : MutableList<R> = initialList.fold(mutableListOf<R>()) { acc, item ->
        if (item is MpTry.Success) {
            item.map { acc.add(it) }
        }
        acc
    }
    return filteredDestinations
}
