package com.hwikun.bacs.auth.rdb.pwhistory.repository;

import com.hwikun.bacs.auth.application.repository.PasswordHistoryRepository;
import com.hwikun.bacs.auth.domain.PasswordHistory;
import com.hwikun.bacs.auth.rdb.pwhistory.entity.HistoryEntity;
import com.hwikun.bacs.auth.rdb.pwhistory.mapper.HistoryEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional
public class HistoryPersistence implements PasswordHistoryRepository {
    private final HistoryEntityMapper mapper;
    private final HistoryJpaRepository historyJpaRepository;
    @Override
    public PasswordHistory save(PasswordHistory history) {
        HistoryEntity entity = historyJpaRepository.save(mapper.toEntity(history));

        return mapper.toDomain(entity);
    }

    @Override
    public List<PasswordHistory> findAllHistory(String username) {
        List<HistoryEntity> historyEntityList = historyJpaRepository.findAllByUsername(username);
        return mapper.toDomain(historyEntityList);
    }

    @Override
    public void delete(PasswordHistory domain) {
        HistoryEntity history = mapper.toEntity(domain);
        historyJpaRepository.delete(history);
    }
}
