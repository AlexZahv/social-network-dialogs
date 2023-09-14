package ru.zahv.alex.socialnetworkdialogs.business.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import ru.zahv.alex.socialnetwork.web.dto.dialogs.DialogMessageRequestDTO
import ru.zahv.alex.socialnetwork.web.dto.dialogs.DialogMessageResponseDTO
import ru.zahv.alex.socialnetworkdialogs.business.persistance.domain.DialogMessageEntity


@Mapper(componentModel = "spring")
interface DialogMessageMapper {

    @Mapping(target = "fromUserId", source = "from")
    @Mapping(target = "toUserId", source = "to")
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "createDate", expression = "java(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ISO_DATE_TIME))")
    @Mapping(target = "dialogId", expression = "java(ru.zahv.alex.socialnetworkdialogs.utils.DialogUtilsKt.getDialogId(dto.getTo(), dto.getFrom()))")
    fun mapToEntity(dto: DialogMessageRequestDTO): DialogMessageEntity

    @Mapping(target = "from", source = "fromUserId")
    @Mapping(target = "to", source = "toUserId")
    fun mapToResponseDTO(entity: DialogMessageEntity): DialogMessageResponseDTO
}
