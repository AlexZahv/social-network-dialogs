package ru.zahv.alex.socialnetworkdialogs.business.service

import ru.zahv.alex.socialnetwork.web.dto.dialogs.DialogMessageRequestDTO
import ru.zahv.alex.socialnetwork.web.dto.dialogs.DialogMessageResponseDTO

interface DialogService {
    fun addMessage(dto: DialogMessageRequestDTO): DialogMessageResponseDTO

    fun getAllMessageList(userId: String, currentUserId: String): List<DialogMessageResponseDTO>
}
