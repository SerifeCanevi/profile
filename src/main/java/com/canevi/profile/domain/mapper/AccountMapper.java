package com.canevi.profile.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.domain.dto.AccountDTO;
import com.canevi.profile.domain.request.AccountCreateRequest;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "accountId", source = "id")
    AccountDTO genereateAccountDTOFromAccount(Account account);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "status", ignore = true)
    Account genereateAccountFromAccountCreateRequest(AccountCreateRequest request);
    
}
