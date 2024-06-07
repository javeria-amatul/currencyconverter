package com.javeria.currencyconverter.presentation.viewstate


import java.util.regex.Pattern

private const val FLOATING_NUMBER_REGEX = "[+-]?([0-9]*[.])?[0-9]+\n"

class AmountState(amount: String? = null) :
    TextFieldState(validator = ::isAmountValid, errorFor = ::amountValidationError) {
    init {
        amount?.let {
            text = it
        }
    }
}

/**
 * Returns an error to be displayed or null if no error was found
 */
private fun amountValidationError(amount: String): String {
    return "Invalid amount: $amount"
}

private fun isAmountValid(amount: String): Boolean {
    return Pattern.matches(FLOATING_NUMBER_REGEX, amount)
}

val AmountStateSaver = textFieldStateSaver(AmountState())
