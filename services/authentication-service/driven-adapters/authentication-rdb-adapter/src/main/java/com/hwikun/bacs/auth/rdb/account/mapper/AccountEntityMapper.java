package com.hwikun.bacs.auth.rdb.account.mapper;

import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.rdb.account.entity.AccountEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AccountEntityMapper {
    AccountEntity toEntity(Account account);
    Account toDomain(AccountEntity entity);
}
