package com.hwikun.bacs.admin.rdb.option.repository;

import com.hwikun.bacs.admin.rdb.option.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OptionJpaRepository extends JpaRepository<OptionEntity, UUID> {
    boolean existsByMenuIdAndOptionNameAndOptionValue(String menuId, String optionName, String optionValue);
    Optional<OptionEntity> findByMenuIdAndOptionNameAndOptionValue(String menuId, String optionName, String optionValue);
    List<OptionEntity> findAllByMenuId(String menuId);
}
