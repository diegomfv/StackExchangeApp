package com.diegofajardo.stackexchangeapp.utils

/**
 * From Item 7: Prefer null or Failure result when the lack of result is possible
 * Effective Kotlin: Marcin Moskala
 * */
sealed class Result<out T> {
    class Success<out T>(val result: T) : Result<T>()
    class Failure(val throwable: Throwable) : Result<Nothing>()
}