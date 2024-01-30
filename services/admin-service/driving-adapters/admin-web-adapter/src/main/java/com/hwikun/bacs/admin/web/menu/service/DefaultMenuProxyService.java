package com.hwikun.bacs.admin.web.menu.service;

import com.hwikun.bacs.admin.application.menu.usecase.MenuUseCase;
import com.hwikun.bacs.admin.domain.Menu;
import com.hwikun.bacs.admin.readmodels.menu.MenuReadModels.MenuInfoReadModel;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.CreateMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.CreateMenuResponseDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.DeleteMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuListRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.UpdateMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.mapper.MenuDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultMenuProxyService implements MenuProxyService {
    private final MenuDtoMapper mapper;
    private final MenuUseCase menuUseCase;

    @Override
    public CreateMenuResponseDto createMenu(CreateMenuRequestDto dto) {
        Menu menu = menuUseCase.createMenu(mapper.toDomain(dto));
        return CreateMenuResponseDto.builder()
                .id(menu.getId())
                .categoryId(menu.categoryId)
                .menuName(menu.menuName)
                .menuPrice(menu.menuPrice)
                .menuDesc(menu.menuDesc)
                .menuImg(menu.menuImg)
                .build();
    }

    @Override
    public Menu readMenu(ReadMenuRequestDto dto) {
        Menu menu = mapper.toDomain(dto);
        return menuUseCase.readMenu(menu);
    }

    @Override
    public List<Menu> readMenuList(ReadMenuListRequestDto dto) {
        return menuUseCase.readMenuList(dto.categoryId());
    }

    @Override
    public boolean deleteMenu(DeleteMenuRequestDto dto) {
        menuUseCase.deleteMenu(mapper.toDomain(dto));
        return true;
    }

    @Override
    public boolean updateMenu(UpdateMenuRequestDto dto) {
        return menuUseCase.updateMenu(mapper.toDomain(dto)) != null;
    }
}
