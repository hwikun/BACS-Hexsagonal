package com.hwikun.bacs.admin.rdb.option.repository;

import com.hwikun.bacs.admin.application.option.repository.OptionRepository;
import com.hwikun.bacs.admin.domain.Option;
import com.hwikun.bacs.admin.exception.option.OptionErrorCode;
import com.hwikun.bacs.admin.rdb.option.entity.OptionEntity;
import com.hwikun.bacs.admin.rdb.option.mapper.OptionEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OptionPersistence implements OptionRepository {
    private final OptionEntityMapper mapper;
    private final OptionJpaRepository optionJpaRepository;
    @Override
    public Option createOption(Option option) {
        OptionEntity entity = optionJpaRepository.save(mapper.toEntity(option));
        return mapper.toDomain(entity);
    }

    @Override
    public boolean existsOption(Option option) {
        return optionJpaRepository.existsByMenuIdAndOptionNameAndOptionValue(
                option.menuId,
                option.optionName,
                option.optionValue
        );
    }

    @Override
    public Optional<Option> findOption(Option option) {
        return optionJpaRepository.findByMenuIdAndOptionNameAndOptionValue(
                option.menuId,
                option.optionName,
                option.optionValue
        ).map(mapper::toDomain);
    }

    @Override
    public List<Option> findOptionList(String menuId) {
        List<OptionEntity> entityList = optionJpaRepository.findAllByMenuId(menuId);
        return mapper.toDomain(entityList);
    }

    @Override
    public void deleteOption(Option option) {
        OptionEntity entity = optionJpaRepository
                .findById(mapper.toEntity(option).getId())
                .orElseThrow(OptionErrorCode.OPTION_NULL::defaultException);
        optionJpaRepository.delete(entity);
    }

    @Override
    public Option updateOption(Option option) {
        OptionEntity entity = optionJpaRepository.findById(mapper.toEntity(option).getId())
                .orElseThrow(OptionErrorCode.OPTION_NULL::defaultException);
        entity.optionPrice = option.optionPrice;
        entity.optionDesc = option.optionDesc;
        return mapper.toDomain(entity);
    }
}
