package com.javeria.currencyconverter

fun Float.roundTo(n : Int) : Float {
    return "%.${n}f".format(this).toFloat()
}
