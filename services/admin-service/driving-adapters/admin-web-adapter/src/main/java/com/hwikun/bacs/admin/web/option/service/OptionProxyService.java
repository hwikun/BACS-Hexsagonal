package com.hwikun.bacs.admin.web.option.service;

import com.hwikun.bacs.admin.domain.Option;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.CreateOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.DeleteOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionListRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.UpdateOptionRequestDto;

import java.util.List;

public interface OptionProxyService {
    Option createOption(CreateOptionRequestDto dto);

    Option readOption(ReadOptionRequestDto dto);

    List<Option> readOptionList(ReadOptionListRequestDto dto);

    boolean deleteOption(DeleteOptionRequestDto dto);

    boolean updateOption(UpdateOptionRequestDto dto);
}
