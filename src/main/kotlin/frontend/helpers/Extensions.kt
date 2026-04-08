package org.example.frontend.helpers

fun String.toPrice(): Float = filter { it.isDigit() }.toFloat() / 100f