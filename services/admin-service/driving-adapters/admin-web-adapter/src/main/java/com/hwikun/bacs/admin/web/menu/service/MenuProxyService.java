package com.hwikun.bacs.admin.web.menu.service;

import com.hwikun.bacs.admin.domain.Menu;
import com.hwikun.bacs.admin.readmodels.menu.MenuReadModels.MenuInfoReadModel;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.CreateMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.CreateMenuResponseDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.DeleteMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuListRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.ReadMenuRequestDto;
import com.hwikun.bacs.admin.web.menu.dto.MenuDto.UpdateMenuRequestDto;

import java.util.List;

public interface MenuProxyService {
    CreateMenuResponseDto createMenu(CreateMenuRequestDto dto);

    Menu readMenu(ReadMenuRequestDto dto);

    List<Menu> readMenuList(ReadMenuListRequestDto dto);

    boolean deleteMenu(DeleteMenuRequestDto dto);

    boolean updateMenu(UpdateMenuRequestDto dto);
}
