package com.canevi.profile.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.*;
import org.springframework.stereotype.Component;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.NullValueCheckStrategy;

@Component
@Mapper(componentModel = ComponentModel.SPRING, 
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountMapper {
}
