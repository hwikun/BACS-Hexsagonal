package com.hwikun.bacs.admin.application.option.repository;

import com.hwikun.bacs.admin.domain.Option;

import java.util.List;
import java.util.Optional;

public interface OptionRepository {
    public Option createOption(Option option);

    boolean existsOption(Option option);

    Optional<Option> findOption(Option option);

    List<Option> findOptionList(String menuId);

    void deleteOption(Option option);

    Option updateOption(Option option);
}
