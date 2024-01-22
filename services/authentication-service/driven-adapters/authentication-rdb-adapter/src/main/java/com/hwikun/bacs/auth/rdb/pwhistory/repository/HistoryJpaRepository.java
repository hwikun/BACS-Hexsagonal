package com.hwikun.bacs.auth.rdb.pwhistory.repository;

import com.hwikun.bacs.auth.rdb.pwhistory.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HistoryJpaRepository extends JpaRepository<HistoryEntity, UUID> {
}
