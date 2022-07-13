package com.arch.mvvmjetpack.screen.main.screenutils

private const val EMAIL_MESSAGE = "Invalid email address"
private const val REQUIRED_MESSAGE = "This field is required"
private const val REGEX_MESSAGE = "Value does not match the regex"

sealed interface Validator
open class Email(var message: String = EMAIL_MESSAGE) : Validator
open class Required(var message: String = REQUIRED_MESSAGE) : Validator
open class Regex(var message: String, var regex: String = REGEX_MESSAGE) : Validator