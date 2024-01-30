package com.hwikun.bacs.admin.web.option.controller;

import com.hwikun.bacs.admin.domain.Option;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.DeleteOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.DeleteOptionResponseDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionListRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.CreateOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.CreateOptionResponseDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionListResponseDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.ReadOptionResponseDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.UpdateOptionRequestDto;
import com.hwikun.bacs.admin.web.option.dto.OptionDto.UpdateOptionResponseDto;
import com.hwikun.bacs.admin.web.option.service.OptionProxyService;
import com.hwikun.bacs.core.timer.ExeTimer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@ExeTimer
@RequestMapping("api/admin/option")
public class OptionApi {
    private final OptionProxyService optionProxyService;

    @PostMapping("/create")
    public CreateOptionResponseDto createOption(
            @RequestBody @Valid CreateOptionRequestDto dto
    ) {
        Option option = optionProxyService.createOption(dto);

        return CreateOptionResponseDto.builder()
                .id(option.getId())
                .menuId(option.menuId)
                .optionName(option.optionName)
                .optionValue(option.optionValue)
                .optionPrice(option.optionPrice)
                .optionDesc(option.optionDesc)
                .build();
    }

    @GetMapping("/info")
    public ReadOptionResponseDto readOption(
            @RequestBody @Valid ReadOptionRequestDto dto
    ) {
        Option option = optionProxyService.readOption(dto);
        return ReadOptionResponseDto.builder()
                .id(option.getId())
                .menuId(option.menuId)
                .optionName(option.optionName)
                .optionValue(option.optionValue)
                .optionPrice(option.optionPrice)
                .optionDesc(option.optionDesc)
                .build();
    }

    @GetMapping("/list")
    public ReadOptionListResponseDto readOption(
            @RequestBody @Valid ReadOptionListRequestDto dto
    ) {
        List<Option> optionList = optionProxyService.readOptionList(dto);
        return ReadOptionListResponseDto.builder()
                .optionList(optionList)
                .build();
    }

    @PostMapping("/delete")
    public DeleteOptionResponseDto deleteOption(
            @RequestBody @Valid DeleteOptionRequestDto dto
    ) {
        boolean isSuccess = optionProxyService.deleteOption(dto);

        return DeleteOptionResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }

    @PostMapping("/update")
    public UpdateOptionResponseDto updateOption(
            @RequestBody @Valid UpdateOptionRequestDto dto
    ) {
        boolean isSuccess = optionProxyService.updateOption(dto);

        return UpdateOptionResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }
}
