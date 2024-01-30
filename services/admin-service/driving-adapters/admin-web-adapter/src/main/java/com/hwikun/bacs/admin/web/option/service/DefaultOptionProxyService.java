package com.hwikun.bacs.admin.web.option.service;

import com.hwikun.bacs.admin.application.option.usecase.OptionUseCase;
import com.hwikun.bacs.admin.domain.Option;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.CreateOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.DeleteOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionListRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.UpdateOptionRequestDto;
import com.hwikun.bacs.admin.web.option.mapper.OptionDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultOptionProxyService implements OptionProxyService {
    private final OptionDtoMapper mapper;
    private final OptionUseCase optionUseCase;

    @Override
    public Option createOption(CreateOptionRequestDto dto) {
        Option option = mapper.toDomain(dto);
        return optionUseCase.createOption(option);
    }

    @Override
    public Option readOption(ReadOptionRequestDto dto) {
        Option option = mapper.toDomain(dto);
        return optionUseCase.readOption(option);
    }

    @Override
    public List<Option> readOptionList(ReadOptionListRequestDto dto) {
        return optionUseCase.readOptionList(dto.menuId());
    }

    @Override
    public boolean deleteOption(DeleteOptionRequestDto dto) {
        Option option = mapper.toDomain(dto);
        optionUseCase.deleteOption(option);
        return true;
    }

    @Override
    public boolean updateOption(UpdateOptionRequestDto dto) {
        Option option = mapper.toDomain(dto);
        return optionUseCase.updateOption(option) != null;
    }
}
