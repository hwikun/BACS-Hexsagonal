package com.hwikun.bacs.admin.application.option.usecase;

import com.hwikun.bacs.admin.domain.Option;

import java.util.List;

public interface OptionUseCase {
    Option createOption(Option option);
    Option readOption(Option option);
    List<Option> readOptionList(String menuId);
    void deleteOption(Option option);
    Option updateOption(Option option);
}
