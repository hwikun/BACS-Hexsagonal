package com.hwikun.bacs.admin.application.option.service;

import com.hwikun.bacs.admin.application.option.repository.OptionRepository;
import com.hwikun.bacs.admin.application.option.usecase.OptionUseCase;
import com.hwikun.bacs.admin.domain.Option;
import com.hwikun.bacs.admin.exception.option.OptionErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OptionService implements OptionUseCase {
    private final OptionRepository optionRepository;
    @Override
    public Option createOption(Option option) {
        if (optionRepository.existsOption(option)) {
            throw OptionErrorCode.OPTION_CONFLICT.defaultException();
        }
        return optionRepository.createOption(option);
    }

    @Override
    public Option readOption(Option option) {
        return optionRepository.findOption(option)
                .orElseThrow(OptionErrorCode.OPTION_NULL::defaultException);
    }

    @Override
    public List<Option> readOptionList(String menuId) {
        return optionRepository.findOptionList(menuId);
    }

    @Override
    public void deleteOption(Option option) {
        Option target = optionRepository.findOption(option)
                        .orElseThrow(OptionErrorCode.OPTION_NULL::defaultException);
        optionRepository.deleteOption(target);
    }

    @Override
    public Option updateOption(Option option) {
        Option target = optionRepository.findOption(option)
                .orElseThrow(OptionErrorCode.OPTION_NULL::defaultException);

        if (option.optionPrice != target.optionPrice) {
            target.optionPrice = option.optionPrice;
        }
        if (option.optionDesc != null) {
            target.optionDesc = option.optionDesc;
        }
        return optionRepository.updateOption(target);
    }
}
