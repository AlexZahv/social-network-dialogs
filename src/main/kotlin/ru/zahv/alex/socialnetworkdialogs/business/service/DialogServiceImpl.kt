package ru.zahv.alex.socialnetworkdialogs.business.service

import org.springframework.stereotype.Service
import ru.zahv.alex.socialnetwork.web.dto.dialogs.DialogMessageRequestDTO
import ru.zahv.alex.socialnetwork.web.dto.dialogs.DialogMessageResponseDTO
import ru.zahv.alex.socialnetworkdialogs.business.mapper.DialogMessageMapper
import ru.zahv.alex.socialnetworkdialogs.business.persistance.repository.DialogMessageDao

@Service
class DialogServiceImpl(
        private val dialogMessageDao: DialogMessageDao,
        private val dialogMessageMapper: DialogMessageMapper
) : DialogService {
    override fun addMessage(dto: DialogMessageRequestDTO): DialogMessageResponseDTO {
        return dialogMessageMapper.mapToResponseDTO(dialogMessageDao.addMessage(dialogMessageMapper.mapToEntity(dto)))
    }

    override fun getAllMessageList(userId: String, currentUserId: String): List<DialogMessageResponseDTO> {
        return dialogMessageDao.getAllMessageList(userId, currentUserId)
                ?.map { dialogMessageEntity ->
                    dialogMessageMapper.mapToResponseDTO(dialogMessageEntity)
                }?.toList() ?: listOf()
    }
}
