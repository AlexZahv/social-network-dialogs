package ru.zahv.alex.socialnetworkdialogs.utils

fun getDialogId(userId: String, currentUserId: String): String {
    val arr = arrayOf(userId, currentUserId)
    arr.sort()
    return arr.joinToString(":")
}
