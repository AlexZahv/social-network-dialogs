package ru.zahv.alex.socialnetworkdialogs.business.persistance.repository

import ru.zahv.alex.socialnetworkdialogs.business.persistance.domain.DialogMessageEntity


interface DialogMessageDao {
    fun addMessage(entity: DialogMessageEntity): DialogMessageEntity

    fun getAllMessageList(userId: String, currentUserId: String): List<DialogMessageEntity>?
}
