package com.hwikun.bacs.admin.web.store.controller;

import com.hwikun.bacs.admin.domain.Store;
import com.hwikun.bacs.admin.domain.types.StoreStatus;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.CreateStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.CreateStoreResponseDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.DeleteStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.DeleteStoreResponseDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.UpdateStoreRequestDto;
import com.hwikun.bacs.admin.web.store.dto.StoreDto.UpdateStoreResponseDto;
import com.hwikun.bacs.admin.web.store.service.StoreProxyService;
import com.hwikun.bacs.core.jwt.JwtUsername;
import com.hwikun.bacs.core.timer.ExeTimer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@ExeTimer
@RequestMapping("api/admin/store")
public class StoreApi {
    private final StoreProxyService storeProxyService;

    @PostMapping("/create")
    public CreateStoreResponseDto createStore(@RequestBody @Valid CreateStoreRequestDto dto) {
        Store store = storeProxyService.createStore(dto, StoreStatus.ACTIVE);

        return CreateStoreResponseDto.builder()
                .id(store.getId())
                .username(store.username)
                .storeName(store.storeName)
                .address(store.address)
                .storeDigit(store.storeDigit)
                .status(store.status)
                .build();
    }

    @PostMapping("/delete")
    public DeleteStoreResponseDto deleteStore(@RequestBody @Valid DeleteStoreRequestDto dto) {
        boolean isSuccess = storeProxyService.deleteStore(dto);
        return DeleteStoreResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }

    @PostMapping("/update")
    public UpdateStoreResponseDto updateStore(@RequestBody @Valid UpdateStoreRequestDto dto) {
        boolean isSuccess = storeProxyService.updateStore(dto) != null;

        return UpdateStoreResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }
    @GetMapping("/example")
    public ResponseEntity<String> getExample(@JwtUsername String username) {
        log.info("Hello, {}", username);
        return ResponseEntity.ok("Hello, " + username);
    }
}
