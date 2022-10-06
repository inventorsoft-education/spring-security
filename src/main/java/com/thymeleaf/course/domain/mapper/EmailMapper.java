package com.thymeleaf.course.domain.mapper;

import com.thymeleaf.course.domain.dto.EmailDto;
import com.thymeleaf.course.domain.entity.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    @Mapping(target = "id", ignore = true)
    void updateEmailFromDto(@MappingTarget Email email, EmailDto emailDto);

    List<EmailDto> mapListOfEmailToListOfDto(List<Email> emails);

    EmailDto mapModelToDto(Email email);

    Email mapDtoToModel(EmailDto emailDto);

}
