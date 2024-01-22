package com.hwikun.bacs.auth.web.mapper;

import com.hwikun.bacs.auth.domain.Account;
import com.hwikun.bacs.auth.domain.types.AccountStatus;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AuthenticationDtoMapper {
    Account toDomain(String username, String password, AccountStatus accountStatus);
}
