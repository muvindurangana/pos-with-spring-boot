package com.springbootacadamy.POS.util.mapper;

import com.springbootacadamy.POS.dto.ItemDTO;
import com.springbootacadamy.POS.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemDTO> entityListTODtoList(List<Item> items);

    List<ItemDTO> pageToList(Page<Item> items);
}
