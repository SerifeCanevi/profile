package com.canevi.profile.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.*;
import org.springframework.stereotype.Component;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.NullValueCheckStrategy;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.domain.dto.AccountDTO;

@Component
@Mapper(componentModel = ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "username", target = "username"),
        @Mapping(source = "password", target = "password"),
        @Mapping(source = "email", target = "email")
    })
    AccountDTO convertAccountToAccountDTO(Account account);

    
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "username", target = "username"),
        @Mapping(source = "password", target = "password"),
        @Mapping(source = "email", target = "email"),
        @Mapping(target = "role", ignore = true),
        @Mapping(target = "status", ignore = true)
    })
    Account convertAccountDTOToAccount(AccountDTO accountDTO);
}
