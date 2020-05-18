package com.lastminute.kmp.data

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import com.arrow.core.algebric.MpTry

fun<T> MpTry<T>.toEither(): Either<Throwable, T> = fold({ Left(it) }, { Right(it) })