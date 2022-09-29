package com.example.springrestsecurity.domain.mapper;

import com.example.springrestsecurity.domain.Email;
import com.example.springrestsecurity.domain.dto.EmailDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    Email toEntity(EmailDto dto);

    EmailDto toDto(Email email);

    void update(EmailDto dto, @MappingTarget Email entity);
}
