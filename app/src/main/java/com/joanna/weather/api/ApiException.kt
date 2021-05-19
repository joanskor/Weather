package com.joanna.weather.api

/**
 * Created by Joanna on 13.05.2021
 */
sealed class ApiException(message: String) : Exception(message) {
    class NotRespondingException : ApiException("")
    class NoInternetConnectionException : ApiException("")
}