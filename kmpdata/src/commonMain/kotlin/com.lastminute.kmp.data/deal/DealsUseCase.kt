package com.lastminute.kmp.data.deal

import com.arrow.core.algebric.MpTry
import com.lastminute.kmp.data.MainScope
import com.lastminute.kmp.data.remotedatasource.Destination
import com.lastminute.kmp.data.service.DealsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface DealsUseCase<R> {
    suspend fun getDestinations(): MpTry<List<Destination>>
    fun getDestinationsCb(success : (List<R>) -> Unit, error : (Throwable) -> Unit)
    companion object
}

fun<R> createDealsUseCase(
        dealsService : DealsService,
        dealsMapper : (Destination) -> R
) : DealsUseCase<R> = DealsUseCaseImpl(dealsService, dealsMapper)

fun<R> createDealsUseCaseWithScope(
        dealsService : DealsService,
        dealsMapper : (Destination) -> R,
        scope : CoroutineScope
) : DealsUseCase<R> = DealsUseCaseImpl(dealsService, dealsMapper, scope)

fun<R> DealsUseCase<R>.createDealsUseCase(
        dealsService : DealsService,
        dealsMapper : (Destination) -> R
) : DealsUseCase<R> = DealsUseCaseImpl(dealsService, dealsMapper)

private class DealsUseCaseImpl<R>(
        private val dealsService : DealsService,
        private val dealsMapper : (Destination) -> R,
        private val scope : CoroutineScope = MainScope()
) : DealsUseCase<R>{

    override suspend fun getDestinations(): MpTry<List<Destination>> {
        return dealsService.getDestinations()
    }

    override fun getDestinationsCb(success : (List<R>) -> Unit, error : (Throwable) -> Unit){
        scope.launch {
            dealsService
                    .getDestinations()
                    .fold(
                            { throwable -> error(throwable) },
                            { data -> success(data.map(dealsMapper)) }
                    )
        }
    }
}