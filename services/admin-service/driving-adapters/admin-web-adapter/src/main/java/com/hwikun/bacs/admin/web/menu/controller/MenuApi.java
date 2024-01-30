package com.hwikun.bacs.admin.web.menu.controller;

import com.hwikun.bacs.admin.domain.Menu;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.CreateMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.CreateMenuResponseDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.DeleteMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.DeleteMenuResponseDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuListRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuListResponseDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuResponseDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.UpdateMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.UpdateMenuResponseDto;
import com.hwikun.bacs.admin.web.menu.service.MenuProxyService;
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
@RequestMapping("api/admin/menu")
public class MenuApi {
    private final MenuProxyService menuProxyService;

    @PostMapping("/create")
    public CreateMenuResponseDto createMenu(@RequestBody @Valid CreateMenuRequestDto dto) {
        return menuProxyService.createMenu(dto);
    }

    @GetMapping("/info")
    public ReadMenuResponseDto readMenu(
            @RequestBody @Valid ReadMenuRequestDto dto
    ) {
        Menu menu = menuProxyService.readMenu(dto);
        return ReadMenuResponseDto.builder()
                .id(menu.getId())
                .menuName(menu.menuName)
                .menuPrice(menu.menuPrice)
                .menuDesc(menu.menuDesc)
                .menuImg(menu.menuImg)
                .build();
    }

    @GetMapping("/list")
    public ReadMenuListResponseDto readMenuList(
            @RequestBody @Valid ReadMenuListRequestDto dto
    ) {
        List<Menu> menuList = menuProxyService.readMenuList(dto);
        return ReadMenuListResponseDto.builder()
                .menuList(menuList)
                .build();
    }

    @PostMapping("/delete")
    public DeleteMenuResponseDto deleteMenu(
            @RequestBody @Valid DeleteMenuRequestDto dto
    ) {
        boolean isSuccess = menuProxyService.deleteMenu(dto);
        return DeleteMenuResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }

    @PostMapping("/update")
    public UpdateMenuResponseDto updateMenu(
            @RequestBody @Valid UpdateMenuRequestDto dto
    ) {
        boolean isSuccess = menuProxyService.updateMenu(dto);
        return UpdateMenuResponseDto.builder()
                .isSuccess(isSuccess)
                .build();
    }
}
