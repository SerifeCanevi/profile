package com.canevi.profile.domain.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.canevi.profile.dao.model.Account;
import com.canevi.profile.domain.dto.AccountDTO;
import com.canevi.profile.domain.request.AccountCreateRequest;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface AccountMapper {

    @Mapping(target = "accountId", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "email", source = "email")
    AccountDTO genereateAccountDTOFromAccount(Account account);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "email", source = "email")
    Account genereateAccountFromAccountCreateRequest(AccountCreateRequest request);
    
}
